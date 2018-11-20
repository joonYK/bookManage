package kr.jy.book;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Library {

    ArrayList<Book> bookList = new ArrayList<Book>();
    LinkedList<Member> memberList = new LinkedList<Member>();

    public Library() {
        bookList.add(new Book("자바"));
        bookList.add(new Book("자바스크립트"));
    }

    //책 추가
    public void addBook(Book addBook) {
        for(Book book : bookList) {
            if(book.getName().equals(addBook.getName())) {
                System.out.println("이미 등록된 책입니다.");
                return;
            }
        }
        bookList.add(addBook);
        System.out.println("책이 등록되었습니다.");
    }

    //책 삭제
    public void removeBook(String bookName) {

    }

    //책 검색
    public void searchBook(String bookName) {
        for(Book book : bookList) {
            if(bookName.equals("") || book.getName().contains(bookName)) {
                System.out.printf("ID:%d, 제목:%s\n", book.getBookId(), book.getName());
            }
        }
    }

    //책을 빌려주다
    public Book rendBook() {
        return null;
    }


}