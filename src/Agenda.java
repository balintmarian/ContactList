
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Agenda extends ContactGroup {
    private Map<String, ContactGroup> agenda;
    private Scanner sc = new Scanner(System.in);


    public Agenda() {
        this.agenda = new TreeMap<>();
    }

    public String inputContactLastName() {
        System.out.println("last name: ");
        String lastName = sc.next();
        return lastName;
    }

    public String inputContactFirstName() {
        System.out.println("first name: ");
        String firstName = sc.next();
        return firstName;
    }

    public String inputContactNumber() {
        System.out.println("number: ");
        String number = sc.next();
        return number;
    }

    public String inputGeneral() {
        System.out.print("->: ");
        String input = sc.next();
        return input;
    }

    public Map<String, ContactGroup> getAgenda() {
        return agenda;
    }

    public void addContact(String lastName, String firstName, String number) {
        Contact contact = new Contact(lastName, firstName, number);

        addContactToGroup(contact);
    }

    private void addContactToGroup(Contact contact) {
        String firstLetter = contact.getFirstLetter();
        ContactGroup contactGroup = agenda.get(firstLetter);

        if (contactGroup == null) {
            // creem un nou contact daca nu exista pt keya cautata
            contactGroup = new ContactGroup();
            agenda.put(firstLetter.toUpperCase(), contactGroup);
        }
        // altfel, adaugam direct contactul
        contactGroup.addContact(contact);
    }

    public void deleteContact(Contact contact) {
        ContactGroup contactGroup = getContactGroupByLetter(contact);

        if (contactGroup != null) {
            contactGroup.getContactGroup().remove(contact);
        }
    }

    public void editContact(Contact contact) {
        // delete old contact
        deleteContact(contact);
        //create a new contact
        addContact(inputContactLastName(), inputContactFirstName(), inputContactNumber());
    }

//    public Contact getContactFromAgenda(Contact contact) {
//        ContactGroup contactGroup = getContactGroupByLetter(contact);
//        if (contactGroup != null) {
//            for (Contact c1 : contactGroup.getContactGroup()) {
//                if (c1.equals(contact)) {
//                    return c1;
//                }
//            }
//        }
//        System.out.println("no such contact found in agenda ");
//        return null;
//    }

    public ContactGroup getContactGroupByLetter(Contact contact) {
        String firstLetter = contact.getFirstLetter();

        return agenda.get(firstLetter.toUpperCase());
    }

    public ContactGroup getContactGroupByLetter() {
        System.out.println("Enter last name or first letter of last name");
        String firstLetter = inputGeneral().substring(0, 1);

        return agenda.get(firstLetter.toUpperCase());
    }

    public void showContactsList() {

        for (Map.Entry<String, ContactGroup> entry : agenda.entrySet()) {
            System.out.println(entry.getKey());
            ContactGroup contactGroup = entry.getValue();
            contactGroup.showContactGroup();
        }
    }
//    private void showTheContact(){
//        for (Map.Entry<String, ContactGroup> entry : agenda.entrySet()) {
//            System.out.println(entry.getKey());
//            ContactGroup contactGroup = entry.getValue();
//            contactGroup.
//        }
//    }


    private String getCorrespondingField(String searchString, ContactGroup contactGroup) {
        String foundField = new String();
        //Set<String> contactGroup = getContactGroupByLetter().getContactGroupToString();
        Set<String> contactGroupStringSet = contactGroup.getContactGroupToString();
        for (String field : contactGroupStringSet) {
            if (field.toLowerCase().contains(searchString.toLowerCase())) {
                System.out.println(field);
                foundField = field;
            }else{
                System.out.println("cant find field");
            }
        }
        return foundField;
        //startsWith()
    }
    //todo: search  the agenda||ContactGroup and find the corresponding Contact for the field resulted in getCorrespondingField()

    public void findContact(String searchString) {
        ContactGroup contactGroup = getContactGroupByLetter();
        String field = getCorrespondingField(searchString, contactGroup);

        for (Contact contact : contactGroup.getContactGroup()) {

            if (contact.getLastName().equalsIgnoreCase(field) ||
                    contact.getFirstName().equalsIgnoreCase(field) ||
                    contact.getNumber().equalsIgnoreCase(field)) {
                System.out.println(contact.toString());
            }else{
                System.out.println("cant find contact from field0");
            }
        }
    }
    public void readFromCSV(){

    }

}



