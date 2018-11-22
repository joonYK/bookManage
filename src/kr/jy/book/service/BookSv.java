package kr.jy.book.service;

import kr.jy.book.dto.Book;
import kr.jy.book.dto.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookSv {

    private ArrayList<Book> bookList = new ArrayList<> ();

    public BookSv() {
        bookList.add(new Book("자바"));
        bookList.add(new Book("자바스크립트"));
    }

    //책 추가
    public boolean addBook(Book addBook) {

        if (bookList.stream ().anyMatch ((book) -> book.getName ().equals (addBook.getName ())))
            return false;

        bookList.add(addBook);
        return true;
    }

    //책 삭제
    public boolean removeBook(int bookId) {
        return bookList.removeIf ((book) -> book.getBookId () == bookId);
    }

    //책 검색
    public List<Book> searchBook(String bookName) {
        List<Book> searchBookList;

        if(bookName == null || bookName.equals("")) {
            searchBookList = new ArrayList<> (bookList);
        } else {
            searchBookList = bookList.stream ().filter ((book) -> book.getName ().contains (bookName)).collect(Collectors.toList ());
        }

        return searchBookList;
    }

    //책 대여
    public boolean lendBook(Member member, int bookId) {
        Optional<Book> data = bookList.stream().filter(b -> b.getBookId() == bookId).findFirst();
        Book book = data.get();

        /**
         * 각 실패 원인을 타입별로 나눠서 반환하도록 수정
         */
        if(member == null || !data.isPresent() || book.isRental()) {
            return false;
        }

        if( member.addBook(book) ) {
            book.setRental(true);
        } else {
            return false;
        }

        return true;

    }

    //책 반납
    public boolean getBackBook(Member member, int bookId) {
        Optional<Book> data = bookList.stream().filter(b -> b.getBookId() == bookId).findFirst();
        Book book = data.get();

        /**
         * 각 실패 원인을 타입별로 나눠서 반환하도록 수정
         */
        if(member == null || !data.isPresent() || !book.isRental()) {
            return false;
        }

        if( member.removeBook(book) ) {
            book.setRental(false);
        } else {
            return false;
        }

        return true;

    }

}