package kr.jy.book;

public class Book {

    private String name;    //책 이름
    private boolean isRental;   //대여 상태

    public Book(String name) {
        this.name = name;
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
