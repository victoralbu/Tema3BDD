import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Main {

    public static EntityManager createEm(String unitName) {
        return Persistence.createEntityManagerFactory(unitName).createEntityManager();
    }

    public static void main(String[] args) {

        java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.SEVERE); // Sets logging level

        // Testing mysql connection
        System.out.println("MySQL connection: " + createEm("mysql").isOpen());

        // Testing postgres connection
        System.out.println("Postgres connection: " + createEm("postgres").isOpen());

    }

}