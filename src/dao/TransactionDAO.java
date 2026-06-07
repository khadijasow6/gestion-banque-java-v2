/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.Clients;
import models.Transactions;

/**
 *
 * @author HP
 */
public class TransactionDAO {

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

}
