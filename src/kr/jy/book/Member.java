package kr.jy.book;

import java.util.LinkedList;
import java.util.List;

public class Member {
    private int memberId;   // 회원 ID
    private String name;    // 이름
    private LinkedList<Book> bookList = new LinkedList<Book>(); //빌린 책 리스트

    public Member(String name) {
        this.memberId = (int)(Math.random() * 10000) + 1;
        this.name = name;
    }

    //책을 빌린다
    public boolean addBook(Book addBook) {
        return bookList.add(addBook);
    }

    //책을 반납한다
    public boolean removeBook(Book book) {
        return bookList.remove(book);
    }

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public String bookListToString() {
        StringBuilder books = new StringBuilder();

        for(Book book : bookList) {
            if(books.length() != 0) books.append(", ");
            books.append(book.getName()+"("+book.getBookId()+")");
        }

        return books.toString();
    }



}
