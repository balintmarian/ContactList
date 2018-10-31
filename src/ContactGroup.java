import java.util.Comparator;
import java.util.TreeSet;
import java.util.Objects;
import java.util.Set;


public class ContactGroup  {

    public Set<Contact> contactGroup ;

    public ContactGroup() {

        this.contactGroup = new TreeSet<Contact>();
    }



    public Set<Contact> getContactGroup() {
        return contactGroup;
    }


}
