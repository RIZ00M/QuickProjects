public class Book {
    private String title;
    private String author;
    private int pages;

    public Book (String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    // This fixes the Book@3af49f1c Book@19469ea2 from appearing got to learn more about it
    @Override
    public String toString() {
        return "\"" + title + "\" by " + author + " // " + pages + " pages //";
    }
}


