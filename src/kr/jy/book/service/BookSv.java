package kr.jy.book.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import kr.jy.book.dto.Book;
import kr.jy.book.dto.Member;
import kr.jy.book.exception.LendBookException;

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
    public void lendBook(Member member, int bookId) throws LendBookException
    {
        Book book = checkLendBookCore (member, bookId);

        member.addBook(book);
        book.setRental(true);
    }

    public boolean checkLendBook (Member member, int bookId)
    {
        try
        {
            checkLendBookCore (member, bookId);

            return true;
        }
        catch (LendBookException e)
        {
            return false;
        }
    }

    /**
     * 책을 대여할수 있는지 체크를 한다.
     * @param member
     * @param bookId
     * @return
     * @throws LendBookException
     */
    private Book checkLendBookCore (Member member, int bookId) throws LendBookException
    {
        Book book = bookList.stream().filter(b -> b.getBookId() == bookId).findFirst()
            .orElseThrow (() -> new LendBookException (LendBookException.LendBookExceptionType.NO_BOOK));

        /**
         * 각 실패 원인을 타입별로 나눠서 반환하도록 수정
         */
        if(member == null)
            throw new LendBookException (LendBookException.LendBookExceptionType.NO_MEMBER);

        if (book.isRental ())
            throw new LendBookException (LendBookException.LendBookExceptionType.IS_RENTAL);

        return book;
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