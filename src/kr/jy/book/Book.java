package kr.jy.book;

public class Book {

    private int bookId;     //책 ID
    private String name;    //책 이름
    private boolean isRental;   //대여 상태

    public Book(String name) {
        this.bookId = (int)(Math.random() * 10000) + 1;
        this.name = name;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRental() {
        return isRental;
    }

    public void setRental(boolean rental) {
        isRental = rental;
    }
}
