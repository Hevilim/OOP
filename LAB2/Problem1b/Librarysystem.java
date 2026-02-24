abstract class LibraryItem {

    private String title;
    private String author;
    private int publicationYear;

    public LibraryItem(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getPublicationYear() { return publicationYear; }

    public String toString() {
        return title + " by " + author + " (" + publicationYear + ")";
    }
}

class Book extends LibraryItem {

    private int numberOfPages;

    public Book(String title, String author, int year, int pages) {
        super(title, author, year);
        this.numberOfPages = pages;
    }

    public int getNumberOfPages() { return numberOfPages; }

    public String toString() {
        return super.toString() + ", Pages: " + numberOfPages;
    }
}
