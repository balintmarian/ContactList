public class Contact {
    private String lastName;
    private String firstName;
    private String number;
    private String firstLetter;

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

}
