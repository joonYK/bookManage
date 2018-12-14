package kr.jy.book.dto;

public class Book {

    private int bookId;     //책 ID
    private String name;    //책 이름
    private String writer;  //저자
    private int price;   //가격
    private boolean isRental;   //대여 상태

    public Book(String name, String writer, int price) {
        this.bookId = (int)(Math.random() * 10000) + 1;
        this.name = name.replace ("&comma;", ",");

        this.writer = writer;
        this.price = price;
    }

    public int getBookId() {
        return bookId;
    }

    public String getName() {
        return name;
    }

    public boolean isRental() {
        return isRental;
    }

    public void setRental(boolean rental) {
        isRental = rental;
    }

    public String getWriter() {
        return writer;
    }

    public int getPrice() {
        return price;
    }

    public String toString() {
        return name.replaceAll (",", "&comma;") + ", " + writer + ", " + price;
    }
}
