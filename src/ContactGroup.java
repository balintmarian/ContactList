import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;


public class ContactGroup {

    public Set<Contact> contactGroup = new TreeSet<>();

    public Set<Contact> getContactGroup() {
        return contactGroup;
    }

    public void addContact(Contact contact) {
        contactGroup.add(contact);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactGroup that = (ContactGroup) o;
        return Objects.equals(contactGroup, that.contactGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactGroup);
    }

    public void showContactGroup() {
        for (Contact contact : contactGroup) {
            System.out.println(contact.toString());
        }
    }
    public Set<String> getContactGroupToString(){
        Set<String> stringSet=new HashSet<>();

        for (Contact contact : contactGroup) {
            stringSet.add(contact.toString());
        }
        return stringSet;
    }
}
