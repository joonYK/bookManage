package kr.jy.book.dto;

public class Book {

    private int bookId;     //책 ID
    private String name;    //책 이름
    private String writer;  //저자
    private int price;   //가격
    private boolean isRental;   //대여 상태

    public Book(String name, int price, String writer) {
        this.bookId = (int)(Math.random() * 10000) + 1;
        this.name = name;
        this.price = price;
        this.writer = writer;
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
}
