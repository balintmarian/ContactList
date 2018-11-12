import java.util.Objects;

public class Contact implements Comparable<Contact> {
    private String lastName;
    private String firstName;
    private String number;


    public Contact() {
    }

    public Contact(String lastName, String firstName, String phoneNumber) {
        this.lastName = firstCharUpperCase(lastName);//toUpperCase(lastName);->done
        this.firstName = firstCharUpperCase(firstName);
        this.number = phoneNumber;

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

    public String getFirstLetter() {
        return lastName.substring(0, 1).toUpperCase();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(lastName, contact.lastName) &&
                Objects.equals(firstName, contact.firstName) &&
                Objects.equals(number, contact.number);
    }

    @Override
    public int hashCode() {

        return Objects.hash(lastName, firstName, number);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", number='" + number + '\'' +
                '}';
    }

    @Override
    public int compareTo(Contact o) {

        int numberCompare = number.compareTo(o.number);
        if (numberCompare == 0) {
            int firstNameCompare = firstName.compareTo(o.firstName);
            if (firstNameCompare == 0) {
                return lastName.compareTo(o.lastName);
            } else {
                return firstNameCompare;
            }
        }
        return numberCompare;
    }
    private String firstCharUpperCase(String string){
        char[] array = string.toCharArray();
        // Modify first element in array.
        array[0] = Character.toUpperCase(array[0]);
        // Return string.
        return new String(array);
    }

}
