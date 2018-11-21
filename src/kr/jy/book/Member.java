package kr.jy.book;

import java.util.LinkedList;
import java.util.List;

public class Member {
    private int memberId;   // 회원 ID
    private String name;    // 이름
    private LinkedList<Book> borrowedBookList = new LinkedList<Book>(); //빌린 책 리스트

    public Member(String name) {
        this.memberId = (int)(Math.random() * 10000) + 1;
        this.name = name;
    }

    //책을 빌린다
    public boolean borrowBook(Book addBook) {
        borrowedBookList.add(addBook);
        return true;
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

    public List<Book> getBorrowedBookList() {
        return borrowedBookList;
    }

}
