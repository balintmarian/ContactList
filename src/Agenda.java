import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Agenda extends ContactGroup {


    private Map<String, ContactGroup> agenda;
    private Scanner sc = new Scanner(System.in);

    ///////////////////////
    public Agenda() {
        this.agenda = new TreeMap<>();
    }

    public Map<String, ContactGroup> getAgenda() {
        return agenda;
    }

    public void addContact(String lastName, String firstName, String number) {
        Contact contact = new Contact(lastName, firstName, number);

        String firstLetter = contact.getFirstLetter();
        ContactGroup contactGroup = agenda.get(firstLetter);

        // caz 1: nu exista contact group pentru litera numelui de familie a contactului
        if (contactGroup == null) {
            // creem un nou contact daca nu exista pt keya cautata
            contactGroup = new ContactGroup();
            agenda.put(firstLetter.toUpperCase(), contactGroup);

        }

        // altfel, adaugam direct contactul
        contactGroup.addContact(contact);

        //System.out.println(agenda.size() + " marimea agendei dupa adaugare");
    }

    public void deleteContact(Contact contact) {
        ContactGroup contactGroup = getContactGroupByLetter(contact);

        if (contactGroup != null) {
            Contact agendaContact = getContactFromAgenda(contact);
            for (Contact c : contactGroup.getContactGroup()) {
                if (agendaContact.equals(c)) {
                    System.out.println("il sterge");
                    contactGroup.getContactGroup().remove(agendaContact);
                }
            }
        }
    }


    public void editContact(Contact contact) {
        ContactGroup contactGroup = getContactGroupByLetter(contact);
        if (contactGroup != null) {
            Contact agendaContact = getContactFromAgenda(contact);
            for (Contact c : contactGroup.getContactGroup()) {
                if (contact.equals(c)) {
                    System.out.println("edit last name: ");
                    agendaContact.setLastName(sc.next());
                    System.out.println("edit first name: ");
                    agendaContact.setFirstName(sc.next());
                    System.out.println("edit number: ");
                    agendaContact.setNumber(sc.next());
                    break;
                }
            }
        }
    }

    public Contact getContactFromAgenda(Contact contact) {
        ContactGroup contactGroup = getContactGroupByLetter(contact);
        if (contactGroup != null) {
            for (Contact c1 : contactGroup.getContactGroup()) {
                if (c1.equals(contact)) {
                    return c1;
                }
            }
        }
        System.out.println("no such contact found in agenda ");
        return null;
    }

    public ContactGroup getContactGroupByLetter(Contact contact) {
        String firstLetter = contact.getFirstLetter();

        return agenda.get(firstLetter.toUpperCase());
    }

    public void showContacts() {

        for (Map.Entry<String, ContactGroup> entry : agenda.entrySet()) {
            System.out.println(entry.getKey());
            ContactGroup contactGroup = entry.getValue();
            contactGroup.showContactGroup();
        }
    }
}



