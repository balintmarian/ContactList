public class Tester {
    public static void main(String[] args) {
        Agenda a=new Agenda();
        Contact c1=new Contact("Ionita","Maricica","0723");
        Contact c2=new Contact("Ilcica","Maricica","0724");
        Contact c3=new Contact("Costescu","Maricica","0725");


        a.addContact("Maricica","Ionescu","1234567890");
        a.addContact("ghita","Ionescu","1234567890");
        a.addContact("craciun","Ionescu","1234567890");
        a.addContact("craciun","popica","1234567890");
        a.addContact("hue1","Hue","1234567890");
        a.addContact("hue1","huehue","1234567890");
        a.showContacts();
    }
}
