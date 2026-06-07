/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author HP
 */
public class DAO {

    private static final String PERSISTENCE_UNIT_NAME = "Gestion_banque";
    private static EntityManagerFactory factory;

    private DAO() {
    }

    public static EntityManagerFactory getInstance() {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return factory;

    }

    public static EntityManager createEntityManager() {
        return getInstance().createEntityManager();
    }

    public static void close() {
        if (factory != null || factory.isOpen()) {
            factory.close();
        }
  
    }
}
