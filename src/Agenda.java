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

    public void addContact(String firstName, String lastName, String number) {
        Contact contact = new Contact(firstName, lastName, number);

        String firstLetter = lastName.substring(0, 1);
        ContactGroup contactGroup = agenda.get(firstLetter);

        // caz 1: nu exista contact group pentru litera numelui de familie a contactului
        if (contactGroup == null) {
            // creem un nou contact group si-l asociem key-ului firstLetter
            contactGroup = new ContactGroup();
            agenda.put(firstLetter, contactGroup);
        }

        // altfel, adaugam direct contactul
        contactGroup.addContact(contact);
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
    public void showContacts(){
        System.out.println("huehue");
        for (Map.Entry<String, ContactGroup> entry:agenda.entrySet()) {
            System.out.println(entry.getKey());
            ContactGroup contactGroup=entry.getValue();
            for(Contact contact:contactGroup.getContactGroup()){
                System.out.println(contact.toString()+"kek");
            }
        }
    }
}


