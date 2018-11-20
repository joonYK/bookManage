package kr.jy.book;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Library {

    ArrayList<Book> bookList = new ArrayList<Book>();
    LinkedList<Member> memberList = new LinkedList<Member>();

    //책 추가
    public void addBook(Book book) {
        bookList.add(book);
    }

    //책 삭제
    public void removeBook(String bookName) {

    }

    //책 검색
    public List<Book> searchBook(String bookName) {
        List<Book> searchBookList = new ArrayList<Book>();

        return searchBookList;
    }

    //책을 빌려주다
    public Book rendBook() {
        return null;
    }


}