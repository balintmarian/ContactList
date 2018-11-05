import java.util.Objects;

public class Contact implements Comparable{
    private String lastName;
    private String firstName;
    private String number;
    private String firstLetter;

    public Contact() {
    }

    public Contact(String lastName, String firstName, String phoneNumber) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.number = phoneNumber;
        this.firstLetter=getFirstLetter(lastName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFirstLetter(String text) {
        String firstLetter = Character.toString(text.charAt(0));
        return firstLetter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(lastName, contact.lastName) &&
                Objects.equals(firstName, contact.firstName) &&
                Objects.equals(number, contact.number) &&
                Objects.equals(firstLetter, contact.firstLetter);
    }

    @Override
    public int hashCode() {

        return Objects.hash(lastName, firstName, number, firstLetter);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", number='" + number + '\'' +
                ", firstLetter='" + firstLetter + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
