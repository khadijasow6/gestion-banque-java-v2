/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.Clients;
import models.Comptes;
import models.Transactions;
import java.util.Date;
import models.Utilisateurs;
import enums.TypeTransaction;
/**
 *
 * @author HP
 */
public class TransactionDAO {
    private CompteDAO compteDAO = new CompteDAO();
    public void depot(Comptes compte, java.math.BigDecimal montant) {

    compte.setSolde(
            compte.getSolde().add(montant)
    );

    compteDAO.updateCompte(compte);
     Transactions t = new Transactions();

    t.setReference("DEP" + System.currentTimeMillis());
    t.setType(TypeTransaction.DEPOT.getValue());
    t.setMontant(montant);
    t.setStatut("succes");
    t.setCreatedAt(new Date());
    t.setCompteSourceId(compte);

    UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
    Utilisateurs user = utilisateurDAO.findById(3);

    t.setTraitePar(user);

    saveTransaction(t);
    

}
    public boolean retrait(Comptes compte, java.math.BigDecimal montant) {
if(compte.getSolde().compareTo(montant) < 0){
        return false;
    }

    compte.setSolde(compte.getSolde().subtract(montant)
    );
    compteDAO.updateCompte(compte);

    Transactions t = new Transactions();

    t.setReference("RET" + System.currentTimeMillis());
    t.setType(TypeTransaction.RETRAIT.getValue());
    t.setMontant(montant);
    t.setStatut("succes");
    t.setCreatedAt(new Date());
    t.setCompteSourceId(compte);

    UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
    Utilisateurs user = utilisateurDAO.findById(3);

    t.setTraitePar(user);

    
        return true;

  }

    public void saveTransaction(Transactions trans) {
        EntityManager em = DAO.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(trans);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive() && tx != null) {
                tx.rollback();
                throw e;
            }
        } finally {
            em.close();
        }

    }
    public List<Transactions> allTransaction(){
        EntityManager em = DAO.createEntityManager();
        try {
            return em.createNamedQuery("Transactions.findAll", Transactions.class)       
                    .getResultList();
        } finally {
            em.close();
        }
    }
    public boolean virement(Comptes source,
                         Comptes destination,
                         java.math.BigDecimal montant) {

    if(source.getSolde().compareTo(montant) < 0){
        return false;
    }

    source.setSolde(
            source.getSolde().subtract(montant)
    );

    destination.setSolde(
            destination.getSolde().add(montant)
    );

    compteDAO.updateCompte(source);
    compteDAO.updateCompte(destination);

    Transactions t = new Transactions();

    t.setReference("VIR" + System.currentTimeMillis());
    t.setType(TypeTransaction.VIRMENT.getValue());
    t.setMontant(montant);
    t.setStatut("succes");
    t.setCreatedAt(new Date());

    t.setCompteSourceId(source);
    t.setCompteDestinationId(destination);

    UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
    Utilisateurs user = utilisateurDAO.findById(3);

    t.setTraitePar(user);

    saveTransaction(t);

    return true;
}

}
