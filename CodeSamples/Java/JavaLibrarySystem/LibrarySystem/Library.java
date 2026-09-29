public class Library {
    // Declare book object array named bookLibrary (Refer back to week 2)
    private Book[] bookLibrary;
    private int count;

    public Library (int size) {
        this.bookLibrary = new Book[size];
        this.count = 0;
    }

    public void addBook(Book book) {
        if (this.count >= this.bookLibrary.length) {
            System.out.println("Library is too full to add another");
            return;
        }

        else {
            this.bookLibrary[this.count] = book;

            this.count++;
            System.out.println("Book added");
        }
    }

    public void listBooks() {
        if (this.count == 0) {
            System.out.println("Library is empty bro");
            return;
        }

        for (int i = 0; i < this.count; i++) {
            System.out.println(this.bookLibrary[i]);
        }
    }

    public void openBook(int index){
        if (index < 0 || index >= this.count ) {
            System.out.println("Invalid entry: " + index);
            return;
        }

        System.out.println(this.bookLibrary[index]);
    }
}

