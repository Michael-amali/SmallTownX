import java.util.ArrayList;
import java.util.List;

public class Library {

    private String address;
    private List<Book> books = new ArrayList<>();

    Book book1 = new Book();

    // CONSTRUCTOR
    public Library(String address){
        this.address = address;
    }

    // POPULATING THE ARRAY WITH BOOKS
    public void addBook(Book book){
        books.add(book);
    }

    // DISPLAY OPENING HOURS
    public static void printOpeningHours(){
        System.out.println("Libraries are open daily from 9am to 5pm.");
    }

    // DISPLAY ADDRESS
    public void printAddress(){
        System.out.println(this.address);
    }

    // BORROW BOOKS
    public void borrowBook(String title) {
        if (books.isEmpty()) {
            System.out.println("Sorry, this book is not in our catalog.");
        }else {
            for(int i = 0; i < books.size(); i++){
                if(books.get(i).getTitle().equals(title)){
                    book1.rented();
                    books.remove(i);
                    break;
                }
            }
            if (book1.isBorrowed()){
                System.out.println("You successfully borrowed " + title);
                book1.borrowed = false;
            }else{
                System.out.println("Sorry, this book is already borrowed.");
            }
        }
    }


    // PRINTING AVAILABLE BOOKS
    public void printAvailableBooks(){
        if (books.isEmpty()) {
            System.out.println("No book in catalog");
        }else{
            for (Book book : books) {
                System.out.println(book.getTitle());
            }
        }
    }


    // RETURN BOOK
        public void returnBook(String title){
            books.add(new Book(title));
            System.out.println("You successfully returned " + title);
            book1.returned();
        }



    // MAIN METHOD
    public static void main(String[] args) {
// Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");
// Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));
// Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();
        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();
// Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();
// Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();
// Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();
// Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }


}