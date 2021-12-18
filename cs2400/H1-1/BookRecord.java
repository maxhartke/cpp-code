package library.service.classes;

import java.util.Arrays;
import java.util.Objects;

public class BookRecord{
    static int staticBookId;
    int bookId;
    String bookTitle;
    String bookAuthors;
    BookGenre bG;

    public BookRecord(){
        staticBookId++;
        bookId = 9999 + staticBookId;
        bookTitle = "";
        bookAuthors = "";

    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public static int getStaticBookId() {
        return staticBookId;
    }

    public static void setStaticBookId(int staticBookId) {
        BookRecord.staticBookId = staticBookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthors() {
        return bookAuthors;
    }

    public void setBookAuthors(String bookAuthors) {
        this.bookAuthors = bookAuthors;
    }

    public void setBookGenre(BookGenre bgn){
        this.bG = bgn;
    }

    public BookGenre getBookGenre(){
        return bG;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookRecord)) return false;
        BookRecord that = (BookRecord) o;
        return
                Objects.equals(getBookTitle(), that.getBookTitle()) &&
                Objects.equals(getBookAuthors(), that.getBookAuthors()) &&
                bG == that.bG;
    }

    public String toString(){
        return "Record No: " + this.bookId + "\n" + "Title: " + this.bookTitle + "\n" + "Genre: " + bG + "\n" + "Authors: " + this.bookAuthors;
    }

}