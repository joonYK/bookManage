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
    public boolean addBook(Book addBook) {
        for(Book book : bookList) {
            if(book.getName().equals(addBook.getName())) {
                return false;
            }
        }
        bookList.add(addBook);
        return true;
    }

    //책 삭제
    public boolean removeBook(int bookId) {
        for(Book book : bookList) {
            if (book.getBookId() == bookId) {
                bookList.remove(book);
                return true;
            }
        }
        return false;
    }

    //책 검색
    public List<Book> searchBook(String bookName) {
        List<Book> searchBookList = new ArrayList<Book>();

        if(bookName == null || bookName.equals("")) {
            searchBookList.addAll(bookList);
        } else {
            for(Book book : bookList) {
                if(book.getName().contains(bookName)) {
                    searchBookList.add(book);
                }
            }
        }

        return searchBookList;
    }

    //책을 빌려주다
    public Book rendBook() {
        return null;
    }

    //회원 검색
    public void searchMember(String bookName) {
        for(Book book : bookList) {
            if(bookName.equals("") || book.getName().contains(bookName)) {
                System.out.printf("ID:%d, 제목:%s\n", book.getBookId(), book.getName());
            }
        }
    }

    //회원 등록
    public void addMember(Member addMember) {
       for(Member member : memberList) {
            if(member.getMemberId() == addMember.getMemberId()) {
                System.out.println("이미 등록된 회원 ID입니다.");
                return;
            }
       }
       memberList.add(addMember);
    }

    //회원 삭제
    public void removeMember() {

    }

}