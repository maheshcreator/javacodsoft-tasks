import java.util.ArrayList;
import java.util.Scanner;

class AddressBook {

    private ArrayList<Contact> contacts;

    public AddressBook() {
        contacts = new ArrayList<Contact>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void removeContact(Contact contact) {
        contacts.remove(contact);
    }

    public Contact searchContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equals(name)) {
                return contact;
            }
        }
        return null;
    }

    public void displayContacts() {
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }
}
public class task5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();

        while (true) {
            System.out.println("Welcome to the Address Book System!");
            System.out.println("1. Add a new contact");
            System.out.println("2. Remove an existing contact");
            System.out.println("3. Search for a contact");
            System.out.println("4. Display all contacts");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = input.next();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = input.next();
                    System.out.print("Enter email address: ");
                    String emailAddress = input.next();
                    Contact contact = new Contact(name, phoneNumber, emailAddress);
                    addressBook.addContact(contact);
                    break;
                case 2:
                    System.out.print("Enter name: ");
                    String nameToRemove = input.next();
                    Contact contactToRemove = addressBook.searchContact(nameToRemove);
                    if (contactToRemove != null) {
                        addressBook.removeContact(contactToRemove);
                        System.out.println(nameToRemove + " has been removed from your contacts.");
                    } else {
                        System.out.println(nameToRemove + " was not found in your contacts.");
                    }
                    break;
                case 3:
                    System.out.print("Enter name: ");
                    String nameToSearch = input.next();
                    Contact contactToSearch = addressBook.searchContact(nameToSearch);
                    if (contactToSearch != null) {
                        System.out.println(contactToSearch);
                    } else {
                        System.out.println(nameToSearch + " was not found in your contacts.");
                    }
                    break;
                case 4:
                    addressBook.displayContacts();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
            input.close();
        }
    }
}

class Contact {
    private String name;
    private String phoneNumber;
    private String emailAddress;

    public Contact(String name, String phoneNumber, String emailAddress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nPhone number: " + phoneNumber + "\nEmail address: " + emailAddress + "\n";
    }
}



    

