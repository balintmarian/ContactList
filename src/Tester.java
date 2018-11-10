import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Tester {


    public static void main(String[] args) {

        Agenda a = new Agenda();

//        Contact c1=new Contact("Ionita","Maricica","0723");
//        Contact c2=new Contact("Ilcica","Maricica","0724");
//        Contact c3=new Contact("Costescu","Maricica","0725");


        a.addContact("Maricica", "Ionescu", "1234567890");
        a.addContact("ghita", "Ionescu", "1234567890");
        a.addContact("craciun", "Ionescu", "1234567890");
        a.addContact("craciun", "popica", "1234567890");
        a.addContact("hue1", "hue", "1234567890");
        a.addContact("hue1", "huehue", "1234567890");
        a.addContact("a", "a", "1");

        a.readFromCSV("Contacts.txt");
        //a.writeTiCSV("Contacts.txt");
        //a.search("hue");
        showMenu(a);


    }

    public static void showMenu(Agenda a) {
        System.out.println("1. Add Contact");
        System.out.println("2. Remove Contact");
        System.out.println("3. Edit Contact");
        System.out.println("4. Show Contacts");
        System.out.println("5. Search Contact...");
        System.out.println("0. Exit App");
        System.out.println("Enter corresponding number");
        doMenu(a);
    }

    public static void doMenu(Agenda a) {
        Scanner sc = new Scanner(System.in);
        String menuIndex = sc.next();
        switch (menuIndex) {
            case ("1"):
                System.out.println("You are adding a new contact");
                a.addContact(a.inputContactLastName(),
                        a.inputContactFirstName(),
                        a.inputContactNumber());
                showMenu(a);
                break;

            case ("2"):
                System.out.println("You are deleting a contact");
                a.deleteContact(enterContact());
                showMenu(a);
                break;

            case ("3"):
                System.out.println("You are editing a contact");
                a.editContact(enterContact());
                showMenu(a);
                break;

            case ("4"):
                System.out.println("You viewing all contacts");
                a.showContactsList();
                showMenu(a);
                break;
            case ("5"):
                System.out.println("You are searching");
                System.out.println("Type here:");
                a.search(a.inputGeneral());
                showMenu(a);
                break;
            case ("0"):
                System.exit(5);
                break;
            default:
                System.out.println("Invalid input" + "\n" + "Accepted input: '0,1,2,3,4'");
                showMenu(a);
                break;
        }
    }

    public static Contact enterContact() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter last name: ");
        String lastName = sc.nextLine();
        System.out.println("enter first name: ");
        String firstName = sc.nextLine();
        System.out.println("enter number: ");
        String number = sc.nextLine();

        Contact contact = new Contact(lastName, firstName, number);
        return contact;
    }


}
