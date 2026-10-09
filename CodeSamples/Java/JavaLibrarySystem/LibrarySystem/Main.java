import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter the title of the book.");
        String title = scan.nextLine();

        System.out.println("Please enter the author of the book.");
        String author = scan.nextLine();

        System.out.println("Please enter the pages of the book.");
        int pages = Integer.parseInt(scan.nextLine());

        Library lib = new Library(2);
        lib.addBook(new Book(title, author, pages));
        lib.addBook(new Book("Dune", "Frank Herbert", 1));
        lib.listBooks();
    }
}