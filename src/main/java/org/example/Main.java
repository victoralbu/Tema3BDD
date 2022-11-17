package org.example;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.logging.Level;

public class Main {

    public static EntityManager createEm(String unitName) {
        return Persistence.createEntityManagerFactory(unitName).createEntityManager();
    }

    public static void main(String[] args) {

        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE); // Sets logging level

        // Testing mysql connection
        System.out.println("Postgres connection: " + createEm("mysql").isOpen());

        // Testing postgres connection
        System.out.println("Postgres connection: " + createEm("postgres").isOpen());

    }

}