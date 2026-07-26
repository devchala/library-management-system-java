import java.util.Scanner;

// Abstract class used to represent common properties of library items
abstract class LibraryItem {
    String title;
    String author;

    public LibraryItem(String t, String a) {
        title = t;
        author = a;
    }

    public abstract void displayInfo();
}

// Book class
class Book extends LibraryItem {

    private boolean isBorrowed = false;

    public Book(String t, String a) {
        super(t, a);
    }

    // Borrow method updated to include borrower name
    public void borrowBook(String borrowerName) {
        if (!isBorrowed) {
            isBorrowed = true;
            System.out.println(borrowerName + " borrowed \"" + title + "\" successfully.");
        } else {
            System.out.println("The book \"" + title + "\" is already borrowed.");
        }
    }

    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

// EBook class
class EBook extends Book {

    public EBook(String t, String a) {
        super(t, a);
    }

    public void displayInfo() {
        System.out.println("EBook Information:");
        super.displayInfo();
    }
}

// PrintedBook class
class PrintedBook extends Book {

    public PrintedBook(String t, String a) {
        super(t, a);
    }

    public void displayInfo() {
        System.out.println("Printed Book Information:");
        super.displayInfo();
    }
}

// Member class
class Member {
    String name;

    public Member(String n) {
        name = n;
    }

    // Borrow method now passes member name to Book
    public void borrow(Book book) {
        book.borrowBook(name);
    }
}

// Main class
public class LibraryManagementSystem1 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Books available in the library
        Book ebook1 = new EBook("Miiltoo", "Eebbisaa Baay’isaa");
        Book ebook2 = new EBook("Sirna Gadaa", "Asmarom Legesse");

        Book printedBook1 = new PrintedBook("Yeroon Siif Haa Dhiistuu", "Isayas Hordofa");
        Book printedBook2 = new PrintedBook("Oromiyaa", "Bula Sirna");

        // Asking user name
        System.out.print("Enter your name please: ");
        String userName = input.nextLine();
        Member member = new Member(userName);

        // Showing available books
        System.out.println("\nAvailable Books:");
        ebook1.displayInfo();
        System.out.println();
        ebook2.displayInfo();
        System.out.println();
        printedBook1.displayInfo();
        System.out.println();
        printedBook2.displayInfo();

        // Asking which book to borrow
        System.out.print("\nEnter book title to borrow: ");
        String bookTitle = input.nextLine();

        // Borrowing process
        if (bookTitle.equalsIgnoreCase(ebook1.title)) {
            member.borrow(ebook1);
        } else if (bookTitle.equalsIgnoreCase(ebook2.title)) {
            member.borrow(ebook2);
        } else if (bookTitle.equalsIgnoreCase(printedBook1.title)) {
            member.borrow(printedBook1);
        } else if (bookTitle.equalsIgnoreCase(printedBook2.title)) {
            member.borrow(printedBook2);
        } else {
            System.out.println("Book not found in the library.");
        }

        input.close();
    }
}






