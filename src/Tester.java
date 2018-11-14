import java.util.Scanner;

public class Tester {
   static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Agenda a = new Agenda();

        a.addContact("Maricica", "Ionescu", "1234567890");
        a.addContact("ghita", "Ionescu", "1234567890");
        a.addContact("craciun", "Ionescu", "1234567890");
        a.addContact("craciun", "popica", "1234567890");
        a.addContact("hue1", "hue", "1234567890");
        a.addContact("hue1", "huehue", "1234567890");
        a.addContact("a", "a", "1");

        a.readFromCSV("Contacts.txt");
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
                a.deleteContact(enterFullContact());
                showMenu(a);
                break;

            case ("3"):
                System.out.println("You are editing a contact");
                a.editContact(enterFullContact());
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
            case("6"):
                showBackupsMenu(a);
                break;
            case ("0"):
                a.writeToCSV("Contacts.txt");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid input" + "\n" + "Accepted input: '0,1,2,3,4'");
                showMenu(a);
                break;
        }
    }

    public static Contact enterFullContact() {
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
    public static void showBackupsMenu(Agenda a){

    BackUpManager manager=new BackUpManager();
        System.out.println("1. Create Backup");
        System.out.println("1. View Backups");
        System.out.println("1. Load Backup");
        System.out.println("1. Remove Backup");
        System.out.println("Enter corresponding number");
        doShowBackupsMenu(a);
    }
    public static void doShowBackupsMenu(Agenda a){
        BackUpManager manager=new BackUpManager();

        String menuIndex = sc.next();
        switch (menuIndex) {
            case ("1"):
                manager.createBackup(a.getCsvFormatContacts());
                break;
    }
}
