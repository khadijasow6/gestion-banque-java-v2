/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.Comptes;
import models.Transactions;
import models.Utilisateurs;
import javax.persistence.NoResultException;
/**
 *
 * @author HP
 */
public class UtilisateurDAO {

    public Utilisateurs connexionUser(String username){
        EntityManager em = DAO.createEntityManager();

        try {

            return (Utilisateurs) em.createNamedQuery(
                    "Utilisateurs.findByUsername",
                    Utilisateurs.class)
                    .setParameter("username", username)
                    .getSingleResult();

        } catch (NoResultException e) {

            return null;

        } finally {

            em.close();

        }
    }

    public List<Utilisateurs> allUtilisateurs(){
        EntityManager em = DAO.createEntityManager();

        try {

            return em.createNamedQuery(
                    "Utilisateurs.findAll",
                    Utilisateurs.class)
                    .getResultList();

        } finally {

            em.close();

        }
    }

    public void createUser(Utilisateurs user) {
        EntityManager em = DAO.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(user);
            tx.commit();

        } catch (Exception e) {

            if (tx != null && tx.isActive()) {
                tx.rollback();
            }

            throw e;

        } finally {

            em.close();

        }
    }
    public Utilisateurs findById(Integer id) {
    EntityManager em = DAO.createEntityManager();

    try {
        return em.find(Utilisateurs.class, id);
    } finally {
        em.close();
    }
}
    
 public void updateUser(Utilisateurs user) {

    EntityManager em = DAO.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    try {

        tx.begin();

        em.merge(user);

        tx.commit();

    } catch (Exception e) {

        if (tx != null && tx.isActive()) {
            tx.rollback();
        }

        throw e;

    } finally {

        em.close();

    }
}
 public void updatePassword(Utilisateurs user) {

    EntityManager em = DAO.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    try {

        tx.begin();

        em.merge(user);

        tx.commit();

    } catch (Exception e) {

        if (tx.isActive()) {
            tx.rollback();
        }

        throw e;

    } finally {

        em.close();

    }
}
    
    
    
}
