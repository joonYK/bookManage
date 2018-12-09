package kr.jy.book.service;

import kr.jy.book.dto.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookSv {

    private static BookSv instance;
    private ArrayList<Book> bookList = new ArrayList<> ();

    public static BookSv getInstance() {
        if(instance == null) instance = new BookSv();
        return instance;
    }

    private BookSv() {
        bookList.add(new Book("자바", 25000, "김준엽"));
        bookList.add(new Book("자바스크립트", 30000, "김준엽"));
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

    public Optional<Book> searchBook(int bookId) {
        return bookList.stream().filter(book -> book.getBookId() == bookId).findFirst();
    }

}