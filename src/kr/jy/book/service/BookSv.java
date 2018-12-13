package kr.jy.book.service;

import kr.jy.book.dto.Book;
import kr.jy.book.file.FileManage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookSv {

    private static BookSv instance;
    private ArrayList<Book> bookList = new ArrayList<> ();
    private FileManage fileManage;

    public static BookSv getInstance() {
        if(instance == null) instance = new BookSv();
        return instance;
    }

    private BookSv() {
        initData();
    }

    //데이터 초기화
    private void initData() {
        fileManage = new FileManage("book.txt");

        List<String> list = fileManage.readFile();
        for(String d : list) {
            String[] arr = d.split(",");
            bookList.add(new Book(arr[0].trim(), arr[1].trim(), Integer.parseInt(arr[2].trim())));
        }

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

    public boolean saveBook() {
        return fileManage.writeFile(bookList.toArray());
    }

}