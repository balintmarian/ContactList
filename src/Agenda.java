
import java.io.*;
import java.util.*;

public class Agenda extends ContactGroup {
    public final String LAST_NAME = "LAST_NAME";
    public final String FIRST_NAME = "FIRST_NAME";
    public final String NUMBER = "NUMBER";
    public final String DELIMITER = ",";

    private Map<String, ContactGroup> agendaMap;
    private Scanner sc = new Scanner(System.in);


    public Agenda() {
        this.agendaMap = new TreeMap<>();
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

    public Map<String, ContactGroup> getAgendaMap() {
        return agendaMap;
    }

    public void addContact(String lastName, String firstName, String number) {
        Contact contact = new Contact(lastName, firstName, number);

        addContactToGroup(contact);
    }

    private void addContactToGroup(Contact contact) {
        String firstLetter = contact.getFirstLetter();
        ContactGroup contactGroup = agendaMap.get(firstLetter);

        if (contactGroup == null) {
            // creem un nou contact daca nu exista pt keya cautata
            contactGroup = new ContactGroup();
            agendaMap.put(firstLetter.toUpperCase(), contactGroup);
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
//        System.out.println("no such contact found in agendaMap ");
//        return null;
//    }

    public ContactGroup getContactGroupByLetter(Contact contact) {
        String firstLetter = contact.getFirstLetter();

        return agendaMap.get(firstLetter.toUpperCase());
    }

    public ContactGroup getContactGroupByLetter() {
        System.out.println("Enter last name or first letter of last name");
        String firstLetter = inputGeneral().substring(0, 1);

        return agendaMap.get(firstLetter.toUpperCase());
    }

    public void showContactsList() {

        for (Map.Entry<String, ContactGroup> entry : agendaMap.entrySet()) {
            System.out.println(entry.getKey());
            ContactGroup contactGroup = entry.getValue();
            contactGroup.showContactGroup();
        }
    }
//    private void showTheContact(){
//        for (Map.Entry<String, ContactGroup> entry : agendaMap.entrySet()) {
//            System.out.println(entry.getKey());
//            ContactGroup contactGroup = entry.getValue();
//            contactGroup.
//        }
//    }

    /*
        private String getCorrespondingField(String searchString, ContactGroup contactGroup) {
            String foundField = new String();
            //Set<String> contactGroup = getContactGroupByLetter().getContactGroupToString();
            Set<String> contactGroupStringSet = contactGroup.getContactGroupToString();
            for (String field : contactGroupStringSet) {
                if (field.toLowerCase().contains(searchString.toLowerCase())) {
                    System.out.println(field);
                    foundField = field;
                } else {
                    System.out.println("cant find field");
                }
            }
            return foundField;
            //startsWith()
        }

        public void findContact(String searchString) {
            ContactGroup contactGroup = getContactGroupByLetter();
            String field = getCorrespondingField(searchString, contactGroup);

            for (Contact contact : contactGroup.getContactGroup()) {

                if (contact.getLastName().equalsIgnoreCase(field) ||
                        contact.getFirstName().equalsIgnoreCase(field) ||
                        contact.getNumber().equalsIgnoreCase(field)) {
                    System.out.println(contact.toString());
                } else {
                    System.out.println("cant find contact from field0");
                }
            }
        }
    */ //old search method-not as good
    public void search(String searchString) {
        //get flat agenda map
        List<Contact> foundContacts = new ArrayList<>();
        //TODO:need a separate method to flat all contacts!!!!!!!!!!!!!!!!!!!!!!needed in writer
        for (Contact contact : flatMap()) {
            if (contact.getFirstName().toLowerCase().contains(searchString)
                    || contact.getLastName().toLowerCase().contains(searchString)
                    || contact.getNumber().contains(searchString)) {
                System.out.println(contact.toString());
            }
        }
    }

    private List<Contact> flatMap() {
        List<Contact> flatListContacts = new ArrayList<>();
        for (String key : agendaMap.keySet()) {

            // flatListContacts.addAll(agendaMap.get(key).getContactGroup().stream().collect(Collectors.toList()));
            flatListContacts.addAll(new ArrayList<>(agendaMap.get(key).getContactGroup()));

        }
        return flatListContacts;
    }
    //flatListContacts.forEach(System.out::println);//just to check all contacts
//        flatListContacts.stream()
//                .filter(contact -> contact.getLastName().contains(searchString))
//                .collect(Collectors.toList());//somehow doesn't work


    public void readFromCSV(String contactsFilePath) {
        // String delimiter = ",";
        String line;
        Map<String, Integer> lineMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(contactsFilePath))) {

            while ((line = reader.readLine()) != null) {

                String[] stringArr = line.split(DELIMITER);

                if (line.contains(LAST_NAME) && line.contains(FIRST_NAME) && line.contains(NUMBER)) {
                    for (Integer index = 0; index < stringArr.length; index++) {
                        switch (stringArr[index]) {
                            case LAST_NAME:
                                lineMap.put(LAST_NAME, index);
                                break;
                            case FIRST_NAME:
                                lineMap.put(FIRST_NAME, index);
                                break;
                            case NUMBER:
                                lineMap.put(NUMBER, index);
                                break;
                            default:
                                System.out.println("unknown column " + stringArr[index]);
                                break;
                        }
                    }
                } else {
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

    private String getCsvFormatContacts(){
       // flatMap();
        //List<String> contactListFormatted=new ArrayList<>();
        String allContactsFormatted="";
        for(Contact contact:flatMap()){
           String line= contact.getLastName()
                   +","+contact.getFirstName()
                   +","+contact.getNumber()+"\n";

            allContactsFormatted+=line;
        }
        return allContactsFormatted;
    }

    public void writeToCSV(String contactsFilePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(contactsFilePath))) {
            // writer.write("hue",csvFileCharacterCounter(contactsFilePath),"Number of characters as int");


            writer.write("LAST_NAME,FIRST_NAME,NUMBER\n"+getCsvFormatContacts());//HARDCODED THE HEADER LINE
            //TODO: make it write as read(), no hard code
        } catch (FileNotFoundException f) {
            System.out.println("Cant find file  ");
        } catch (IOException io) {
            System.out.println("Cant find file IOEXEPTION");
        }
    }
//    public int csvFileCharacterCounter(String contactsFilePath){
//        String line;
//        int charCounter=0;
//        try (BufferedReader reader = new BufferedReader(new FileReader(contactsFilePath))) {
//            while ((line = reader.readLine()) != null) {
//                charCounter+=line.length();
//            }
//
//        }catch (FileNotFoundException exception) {
//            System.out.println("cant find file contacts");
//        } catch (IOException io) {
//            System.out.println("IOException");
//        }
//        return charCounter;
//    }// no longer needed to write file

}



