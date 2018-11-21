package kr.jy.book;

import java.util.LinkedList;

public class Member {
    private int memberId;   // 회원 ID
    private String name;    // 이름
    LinkedList<Book> brrowedBookList = new LinkedList<Book>(); //빌린 책 리스트

    //책을 빌린다
    public void borrowBook(Book book) {

    }

    //책을 반납한다
    public void returnBook(Book book) {

    }

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void setName(String name) {
        this.name = name;
    }
}
