
import java.io.*;
import java.util.*;

public class Agenda extends ContactGroup {
    public  final String LAST_NAME = "LAST_NAME";
    public  final String FIRST_NAME = "FIRST_NAME";
    public  final String NUMBER = "NUMBER";
    public final String DELIMITER=",";

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
    public void readFromCSV(String contactsFilePath) {
       // String delimiter = ",";
        String line;
        Integer index;
        Map<String, Integer> lineMap = new HashMap<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(contactsFilePath))) {

            while ((line=reader.readLine()) != null) {

                String[] stringArr = line.split(DELIMITER);

                if (line.contains(LAST_NAME) && line.contains(FIRST_NAME) && line.contains(NUMBER)) {
                    for (index = 0; index < stringArr.length; index++) {
                        switch(stringArr[index]) {
                            case LAST_NAME:
                                lineMap.put(LAST_NAME,index);
                                break;
                            case FIRST_NAME:
                                lineMap.put(FIRST_NAME,index);
                                break;
                            case NUMBER:
                                lineMap.put(NUMBER,index);
                                break;
                            default:
                                System.out.println("unknown column " +stringArr[index]);
                                break;
                        }
                    }
                }else{
                    addContact(stringArr[lineMap.get(LAST_NAME)],
                            stringArr[lineMap.get(FIRST_NAME)],
                            stringArr[lineMap.get(NUMBER)]);
                }
            }
        } catch (FileNotFoundException exception) {
            System.out.println("cant find file contacts");
        } catch (IOException io) {
            System.out.println("IOException");
        }
    }
//    public void writeTiCSV(){
//        BufferedWriter writer=new BufferedWriter();
//
//    }

}



