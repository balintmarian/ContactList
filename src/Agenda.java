import java.util.*;

public class Agenda extends ContactGroup {


    private Map<String, ContactGroup> agenda;
    // private Set<ContactGroup> contactGroups = new TreeSet<ContactGroup>();
    private List<Contact> contactGroup = new ArrayList<>();
    // private Contact c= new Contact();
    Scanner sc = new Scanner(System.in);

    ///////////////////////
    public Agenda() {
        this.agenda = new TreeMap<>();
    }

    public Map<String, ContactGroup> getAgenda() {
        return agenda;
    }

    public void addContact(String lastName, String firstName, String number) {
        Contact contact = new Contact(lastName, firstName, number);

        String firstLetter = lastName.substring(0, 1);
        ContactGroup contactGroup = agenda.get(firstLetter);

        // caz 1: nu exista contact group pentru litera numelui de familie a contactului
        if (contactGroup == null) {
            // creem un nou contact daca nu exista pt keya cautata
            contactGroup = new ContactGroup();

        }

        // altfel, adaugam direct contactul
        contactGroup.addContact(contact);
        agenda.put(firstLetter, contactGroup);
        System.out.println(agenda.size() + " marimea agendei dupa adaugare");
    }

    public void deleteContact(Contact contact) {
        String firstLetter = contact.getLastName().substring(0, 1);

        ContactGroup contactGroup = agenda.get(firstLetter);

        if (contactGroup.getContactGroup().contains(contact)) {
            contactGroup.getContactGroup().remove(contact);

        } else {
            System.out.println("cant find contact: " + contact.getFirstName() + contact.getLastName());
        }
    }


    public void editContact(Contact contact) {
        String firstLetter = contact.getLastName().substring(0, 1);

        ContactGroup contactGroup = agenda.get(firstLetter);

        if (contactGroup.getContactGroup().contains(contact)) {
            contactGroup.setLastName(sc.next());
            contactGroup.setFirstName(sc.next());
            contactGroup.setNumber(sc.next());
        }
    }

    public void showContacts() {
//        for (Map.Entry<String, ContactGroup> entry : agenda.entrySet()) {
//            System.out.println(entry.getKey());
//            ContactGroup contactGroup = entry.getValue();
//            for (Contact contact : contactGroup.getContactGroup()) {
//                System.out.println(contact.toString());
//                // printeaza un singur contact pe key
//            }
//        }
        for (Map.Entry<String, ContactGroup> entry : agenda.entrySet()) {

            System.out.println("\n" + entry.getKey());

            entry.getValue().getContactGroup().forEach(System.out::println);

        }
    }
}


