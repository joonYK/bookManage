package kr.jy.book.service;

import kr.jy.book.dto.Book;
import kr.jy.book.dto.Member;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {

    private ArrayList<Book> bookList = new ArrayList<> ();
    private LinkedList<Member> memberList = new LinkedList<> ();

    public Library() {
        bookList.add(new Book("자바"));
        bookList.add(new Book("자바스크립트"));
        memberList.add(new Member("준엽"));
    }

    //책 추가
    public boolean addBook(Book addBook) {

        if (bookList.stream ().anyMatch ((book) -> book.getName ().equals (addBook.getName ())))
            return false;

        /*for(Book book : bookList) {
            if(book.getName().equals(addBook.getName())) {
                return false;
            }
        }*/
        bookList.add(addBook);
        return true;
    }

    //책 삭제
    public boolean removeBook(int bookId) {

        return bookList.removeIf ((book) -> book.getBookId () == bookId);

        /*for(Book book : bookList) {
            if (book.getBookId() == bookId) {
                bookList.remove(book);
                return true;
            }
        }
        return false;*/
    }

    //책 검색
    public List<Book> searchBook(String bookName) {
        List<Book> searchBookList;

        if(bookName == null || bookName.equals("")) {
            searchBookList = new ArrayList<> (bookList);
        } else {

            searchBookList = bookList.stream ().filter ((book) -> book.getName ().contains (bookName)).collect(Collectors.toList ());

            /*for(Book book : bookList) {
                if(book.getName().contains(bookName)) {
                    searchBookList.add(book);
                }
            }*/
        }

        return searchBookList;
    }

    //책 대여
    public boolean lendBook(int memberId, int bookId) {
        Member member = null;
        Book book = null;

        for(Member m : memberList) {
            if(m.getMemberId() == memberId) {
                member = m;
            }
        }

        for(Book b : bookList) {
            if(b.getBookId() == bookId) {
                book = b;
            }
        }

        /**
         * 각 실패 원인을 타입별로 나눠서 반환하도록 수정
         */
        if(member == null || book == null || book.isRental()) {
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
    public boolean getBackBook(int memberId, int bookId) {
        Member member = null;
        Book book = null;

        for(Member m : memberList) {
            if(m.getMemberId() == memberId) {
                member = m;
            }
        }

        for(Book b : bookList) {
            if(b.getBookId() == bookId) {
                book = b;
            }
        }

        /**
         * 각 실패 원인을 타입별로 나눠서 반환하도록 수정
         */
        if(member == null || book == null || !book.isRental()) {
            return false;
        }

        if( member.removeBook(book) ) {
            book.setRental(false);
        } else {
            return false;
        }

        return true;

    }



    //회원 검색
    public List<Member> searchMember(String memberName) {
        List<Member> searchMemberList = new ArrayList<Member>();

        if(memberName == null || memberName.equals("")) {
            searchMemberList.addAll(memberList);
        } else {
            for(Member member : memberList) {
                if(member.getName().contains(memberName)) {
                    searchMemberList.add(member);
                }
            }
        }

        return searchMemberList;
    }

    //회원 등록
    public boolean addMember(Member addMember) {
       for(Member member : memberList) {
            if(member.getMemberId() == addMember.getMemberId()) {
                return false;
            }
       }
       memberList.add(addMember);
       return true;
    }

    //회원 삭제
    public boolean removeMember(int memberId) {
        for(Member member : memberList) {
            if (member.getMemberId() == memberId) {
                memberList.remove(member);
                return true;
            }
        }
        return false;
    }

}