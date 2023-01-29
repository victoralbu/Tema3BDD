import dao.impl.MessageDAOImpl;
import dao.interfaces.MessageDAO;
import entities.Message;
import enums.Level;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);
    static MessageDAO messageDAO = new MessageDAOImpl();

    public static EntityManager createEm(String unitName) {
        return Persistence.createEntityManagerFactory(unitName).createEntityManager();
    }

    public static void main(String[] args) {

        // Testing mysql connection
        System.out.println("MySQL connection: " + createEm("mysql").isOpen());

        // Testing postgres connection
        System.out.println("Postgres connection: " + createEm("postgres").isOpen() + '\n');


        while (true) {
            System.out.println("Welcome! Please select one option:");
            System.out.println("1. Create a message");
            System.out.println("2. View messages");
            System.out.println("3. Quit!");
            int option = input.nextInt();
            switch (option) {
                case 1:
                    while (true) {
                        System.out.println("1. Create error message");
                        System.out.println("2. Create warning message");
                        System.out.println("3. Create info message");
                        System.out.println("4. Back");
                        int option3 = input.nextInt();
                        switch (option3) {
                            case 1:
                                System.out.println("Enter message text:");
                                String text = input.next();
                                Message message = new Message(text, Level.ERROR);
                                messageDAO.create(message);
                                messageOptions(message);
                                break;
                            case 2:
                                System.out.println("Enter message text:");
                                String text2 = input.next();
                                Message message2 = new Message(text2, Level.WARNING);
                                messageDAO.create(message2);
                                messageOptions(message2);
                                break;
                            case 3:
                                System.out.println("Enter message text:");
                                String text3 = input.next();
                                Message message3 = new Message(text3, Level.INFO);
                                messageDAO.create(message3);
                                messageOptions(message3);
                                break;
                            case 4:
                                break;
                            default:
                                System.out.println("Please select a valid option!");
                        }
                        break;
                    }
                    break;
                case 2:
                    while (true) {
                        System.out.println("1. View all error messages");
                        System.out.println("2. View all warning messages");
                        System.out.println("3. View all info messages");
                        System.out.println("4. Back");
                        int option2 = input.nextInt();
                        switch (option2) {
                            case 1:
                                messageDAO.getErrors().forEach(message1 -> System.out.println(message1.toString()));
                                System.out.println("------------------------------------------------------------------------------------------");
                                break;
                            case 2:
                                messageDAO.getErrors().forEach(message1 -> System.out.println(message1.toString()));
                                System.out.println("------------------------------------------------------------------------------------------");
                                messageDAO.getWarnings().forEach(message1 -> System.out.println(message1.toString()));
                                System.out.println("------------------------------------------------------------------------------------------");
                                break;
                            case 3:
                                messageDAO.getErrors().forEach(message1 -> System.out.println(message1.toString()));
                                System.out.println("------------------------------------------------------------------------------------------");
                                messageDAO.getWarnings().forEach(message1 -> System.out.println(message1.toString()));
                                System.out.println("------------------------------------------------------------------------------------------");
                                messageDAO.getInfo().forEach(message1 -> System.out.println(message1.toString()));
                                System.out.println("------------------------------------------------------------------------------------------");
                                break;
                            case 4:
                                break;
                            default:
                                System.out.println("Please select a valid option!");
                        }
                        break;
                    }
                    break;
                case 3:
                    System.out.println("Thank you!");
                    return;
                default:
                    System.out.println("Please select a valid option!");
            }
        }
    }

    public static void messageOptions(Message message) {
        while (true) {
            System.out.println("1. Save");
            System.out.println("2. Edit");
            System.out.println("3. Delete");
            int option = input.nextInt();
            switch (option) {
                case 1:
                    return;
                case 2:
                    System.out.print("Edit text: ");
                    System.out.println(message.getText());
                    String text = input.next();
                    message.setText(text);
                    messageDAO.update(message);
                    break;
                case 3:
                    messageDAO.delete(message);
                    return;
                default:
                    System.out.println("Please select a valid option!");
            }
        }
    }
}