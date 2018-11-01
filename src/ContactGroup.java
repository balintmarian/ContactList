import java.util.Comparator;
import java.util.TreeSet;
import java.util.Objects;
import java.util.Set;


public class ContactGroup extends Contact  {

    public Set<Contact> contactGroup ;

    public ContactGroup() {

        this.contactGroup = new TreeSet<Contact>();
    }



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

}
