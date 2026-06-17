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
import enums.StatutCompte;
import enums.TypeCompte;
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
    if(compte.getStatut().equals(
        StatutCompte.INACTIF.getValue())){

    compte.setStatut(
            StatutCompte.ACTIF.getValue());
}

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
if(nombreRetraitsDuJour(compte) >= 3){
    return false;
}
   if(compte.getTypeCompte().equals(
        TypeCompte.COURANT.getValue())
        &&
        montant.compareTo(
                java.math.BigDecimal.valueOf(1000000)
        ) > 0){

    return false;
}

if(compte.getTypeCompte().equals(
        TypeCompte.EPARGNE.getValue())
        &&
        montant.compareTo(
                java.math.BigDecimal.valueOf(600000)
        ) > 0){

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
    t.setMotif("500");
    t.setCreatedAt(new Date());
    t.setCompteSourceId(compte);

    UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
    Utilisateurs user = utilisateurDAO.findById(3);

    t.setTraitePar(user);
      saveTransaction(t);
    
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
    t.setMotif("1000");
    t.setCreatedAt(new Date());

    t.setCompteSourceId(source);
    t.setCompteDestinationId(destination);

    UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
    Utilisateurs user = utilisateurDAO.findById(3);

    t.setTraitePar(user);

    saveTransaction(t);

    return true;
}
    public int nombreRetraitsDuJour(Comptes compte){

    int compteur = 0;

    for(Transactions t : allTransaction()){

        if(t.getType().equals(
                TypeTransaction.RETRAIT.getValue())
                &&
           t.getCompteSourceId().getId()
                .equals(compte.getId())){

            compteur++;
        }
    }

    return compteur;
}
    public java.math.BigDecimal totalDepot(){

    java.math.BigDecimal total =
            java.math.BigDecimal.ZERO;

    for(Transactions t : allTransaction()){

        if(t.getType().equals(
                TypeTransaction.DEPOT.getValue())){

            total = total.add(
                    t.getMontant());
        }
    }

    return total;
}
    
    public java.math.BigDecimal totalRetrait(){

    java.math.BigDecimal total =
            java.math.BigDecimal.ZERO;

    for(Transactions t : allTransaction()){

        if(t.getType().equals(
                TypeTransaction.RETRAIT.getValue())){

            total = total.add(
                    t.getMontant());
        }
    }

    return total;
}
public java.math.BigDecimal totalFrais(){

    java.math.BigDecimal total =
            java.math.BigDecimal.ZERO;

    for(Transactions t : allTransaction()){

        if(t.getMotif() != null &&
           !t.getMotif().isEmpty()){

            total = total.add(
                    new java.math.BigDecimal(
                            t.getMotif()));
        }
    }

    return total;
}
public List<Transactions> transactionsAujourdhui(){

    List<Transactions> resultat =
            new java.util.ArrayList<>();

    java.text.SimpleDateFormat sdf =
            new java.text.SimpleDateFormat("dd/MM/yyyy");

    String aujourdhui =
            sdf.format(new Date());

    for(Transactions t : allTransaction()){

        String dateTransaction =
                sdf.format(t.getCreatedAt());

        if(dateTransaction.equals(aujourdhui)){

            resultat.add(t);
        }
    }

    return resultat;
}
public List<Transactions> transactionsAnneeCourante(){

    List<Transactions> resultat =
            new java.util.ArrayList<>();

    java.util.Calendar cal =
            java.util.Calendar.getInstance();

    int anneeActuelle =
            cal.get(java.util.Calendar.YEAR);

    for(Transactions t : allTransaction()){

        cal.setTime(t.getCreatedAt());

        int anneeTransaction =
                cal.get(java.util.Calendar.YEAR);

        if(anneeTransaction == anneeActuelle){

            resultat.add(t);
        }
    }

    return resultat;
}
public List<Transactions> transactionsMoisCourant(){

    List<Transactions> resultat =
            new java.util.ArrayList<>();

    java.util.Calendar cal =
            java.util.Calendar.getInstance();

    int moisActuel =
            cal.get(java.util.Calendar.MONTH);

    int anneeActuelle =
            cal.get(java.util.Calendar.YEAR);

    for(Transactions t : allTransaction()){

        cal.setTime(t.getCreatedAt());

        int moisTransaction =
                cal.get(java.util.Calendar.MONTH);

        int anneeTransaction =
                cal.get(java.util.Calendar.YEAR);

        if(moisTransaction == moisActuel
                && anneeTransaction == anneeActuelle){

            resultat.add(t);
        }
    }

    return resultat;
}
public List<Transactions> transactionsSemaineCourante(){

    List<Transactions> resultat =
            new java.util.ArrayList<>();

    java.util.Calendar cal =
            java.util.Calendar.getInstance();

    int semaineActuelle =
            cal.get(java.util.Calendar.WEEK_OF_YEAR);

    int anneeActuelle =
            cal.get(java.util.Calendar.YEAR);

    for(Transactions t : allTransaction()){

        cal.setTime(t.getCreatedAt());

        int semaineTransaction =
                cal.get(java.util.Calendar.WEEK_OF_YEAR);

        int anneeTransaction =
                cal.get(java.util.Calendar.YEAR);

        if(semaineTransaction == semaineActuelle
                && anneeTransaction == anneeActuelle){

            resultat.add(t);
        }
    }

    return resultat;
}
public List<Transactions> transactionsSixDerniersMois(){

    List<Transactions> resultat =
            new java.util.ArrayList<>();

    java.time.LocalDate limite =
            java.time.LocalDate.now().minusMonths(6);

    for(Transactions t : allTransaction()){

        java.time.LocalDate dateTransaction =
                t.getCreatedAt()
                .toInstant()
                .atZone(
                    java.time.ZoneId.systemDefault())
                .toLocalDate();

        if(dateTransaction.isAfter(limite)
                || dateTransaction.isEqual(limite)){

            resultat.add(t);
        }
    }

    return resultat;
}
}
