import java.util.Scanner;

public class Tester {

    public static void main(String[] args) {

        Agenda a = new Agenda();
        showMenu(a);
//        Contact c1=new Contact("Ionita","Maricica","0723");
//        Contact c2=new Contact("Ilcica","Maricica","0724");
//        Contact c3=new Contact("Costescu","Maricica","0725");


//        a.addContact("Maricica", "Ionescu", "1234567890");
//        a.addContact("ghita", "Ionescu", "1234567890");
//        a.addContact("craciun", "Ionescu", "1234567890");
//        a.addContact("craciun", "popica", "1234567890");
//        a.addContact("hue1", "Hue", "1234567890");
//        a.addContact("hue1", "huehue", "1234567890");
//        a.addContact("a", "a", "1");
//        a.showContacts();
//        // a.editContact(enterContact());
//        a.deleteContact(enterContact());
//        a.showContacts();


    }

    public static void showMenu(Agenda a) {
        System.out.println("1. Add Contact");
        System.out.println("2. Remove Contact");
        System.out.println("3. Edit Contact");
        System.out.println("4. Show Contacts");
        System.out.println("0. Search Contact...");
        System.out.println("Enter coresponding number");
        doMenu(a);
    }

    public static void doMenu(Agenda a) {
        Scanner sc=new Scanner(System.in);
        int menuIndex = sc.nextInt();
        switch (menuIndex) {
            case (1):
                System.out.println("You are entering a contact");
                a.addContact(enterContact());
                showMenu(a);
                break;
            case (2):
                System.out.println("You are deleting a contact");
                a.deleteContact(enterContact());
                showMenu(a);
                break;
            case (3):
                System.out.println("You are editing a contact");
                a.editContact(enterContact());
                showMenu(a);
                break;
            case (4):
                System.out.println("You viewing all contacts");
                a.showContacts();
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
