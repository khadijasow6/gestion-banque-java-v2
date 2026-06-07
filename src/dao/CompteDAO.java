/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import enums.TypeCompte;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.Clients;
import models.CompteDTO;
import models.CompteMapper;
import models.Comptes;

/**
 *
 * @author HP
 */
public class CompteDAO {

    public Comptes rechercheCompte(String numero) {
        EntityManager em = DAO.createEntityManager();
        try {
            return em.createNamedQuery("Comptes.findByNumeroCompte", Comptes.class)
                    .setParameter("numero", numero)
                    .getSingleResult();
        } finally {
            em.close();
        }
    }

    public void createCompte(Comptes account) {
        EntityManager em = DAO.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            if (account.getClient().getId() == null) {
                em.persist(account.getClient());
                em.flush();

            }
            em.persist(account);
            tx.commit();

        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();

            }
        } finally {
            em.close();
        }

    }

    public List<Comptes> allComptes() {
        EntityManager em = DAO.createEntityManager();
        try {
            return em.createNamedQuery("Comptes.findAll", Comptes.class)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public String GenererNumeroCompte(TypeCompte type) {
        String prefix = type == TypeCompte.COURANT ? "CC" : "CE";
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyMMdd"));
        int total = allComptes().size() + 1;
        String sequence = String.format("%04d", total);
        return prefix + date + sequence;
    }

    public List<CompteDTO> AffichageCompte() {
        return CompteMapper.toDtoList(allComptes());
    }
}
