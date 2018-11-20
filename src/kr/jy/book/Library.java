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
    public void removeBook(String bookName) {

    }

    //책 검색
    public List<Book> searchBook(String bookName)
    {
        List<Book> result;

        if (bookName == null || bookName.equals(""))
        {
            result = new ArrayList<Book> (bookList);
        }
        else
        {
            result = new ArrayList<Book> ();

            for(Book book : bookList) {
                if(book.getName().contains(bookName)) {
                    result.add (book);
                }
            }
        }

        return result;


    }

    //책을 빌려주다
    public Book rendBook() {
        return null;
    }


}