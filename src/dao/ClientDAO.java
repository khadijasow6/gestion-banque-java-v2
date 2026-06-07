/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import models.Clients;
import models.Utilisateurs;

/**
 *
 * @author HP
 */
public class ClientDAO {

    public Clients getClientByCNI(String cni) {
        EntityManager em = DAO.createEntityManager();
        Clients cl = null;
        try {
            cl = (Clients) em.createNamedQuery("Clients.findByCni", Clients.class)
                    .setParameter("cin", cni)
                    .getSingleResult();
        }catch(NoResultException e){
            return null;
        }
            finally {
            em.close();
        }
        return cl;
    }

    public void createOrUpdate(Utilisateurs user) {
        EntityManager em = DAO.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            if (user.getId() == null) {
                em.persist(user);
            } else {
                em.merge(user);
            }
            et.commit();
        } catch (Exception e) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }

    }
    public List<Clients> allClients(){
        EntityManager em = DAO.createEntityManager();
        try {
            return em.createNamedQuery("Clients.findAll", Clients.class)       
                    .getResultList();
        } finally {
            em.close();
        }
    }

}
