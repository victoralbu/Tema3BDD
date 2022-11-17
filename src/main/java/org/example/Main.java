package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.logging.Level;

public class Main {
    public static void main(String[] args) {

        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE); // Sets logging level

        // Testing mysql connection
        EntityManagerFactory mysqlEmf = Persistence.createEntityManagerFactory("mysql");
        EntityManager mysqlEm = mysqlEmf.createEntityManager();
        System.out.println("Mysql connection: " + mysqlEm.isOpen());

        // Testing postgres connection
        EntityManagerFactory postgresEmf = Persistence.createEntityManagerFactory("postgres");
        EntityManager postgresEm = postgresEmf.createEntityManager();
        System.out.println("Postgres connection: " + postgresEm.isOpen());

    }

}