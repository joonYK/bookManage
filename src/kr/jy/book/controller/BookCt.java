package kr.jy.book.controller;

import kr.jy.book.dto.Book;
import kr.jy.book.service.BookSv;

import java.util.List;
import java.util.Scanner;

public class BookCt {
    private BookSv bookSv = BookSv.getInstance();
    private Scanner input = new Scanner(System.in);

    // 도서관리
    public void manage() {
        int actionType = 0;

        while(true) {
            System.out.print("\n[1]:책 검색  [2]:책 등록  [3]:책 삭제 [9]:뒤로가기\n>> ");
            actionType = input.nextInt();
            input.nextLine();

            if(actionType == 1) {
                this.searchBook();

            } else if(actionType == 2) {
                this.addBook();

            } else if(actionType == 3) {
                this.removeBook();

            } else if(actionType == 9) {
                break;
            }
        }
    }

    // 도서검색
    private void searchBook() {
        System.out.print("\n검색할 책 제목을 입력하세요(빈 문자열 입력 시 모든 책 검색)\n>> ");
        List<Book> searchList = bookSv.searchBook(input.nextLine());

        if(searchList == null || searchList.size() == 0) {
            System.out.println("검색된 책이 없습니다.");
        } else {
            for(Book book : searchList) {
                System.out.printf("ID:%d, 제목:%s, 가격:%d, 저자:%s, 대여상태:%s\n", book.getBookId(), book.getName(), book.getPrice(), book.getWriter(), book.isRental()?"O":"X");
            }
        }
    }

    // 도서등록
    private void addBook() {
        System.out.print("\n등록할 책 제목을 입력하세요.\n>> ");
        String bookName = input.nextLine();

        System.out.print("\n등록할 책 가격을 입력하세요.\n>> ");
        int price  = Integer.parseInt(input.nextLine());

        System.out.print("\n등록할 책 저자를 입력하세요.\n>> ");
        String writer = input.nextLine();

        if( bookSv.addBook(new Book(bookName, price, writer)) ) {
            System.out.println("책이 등록되었습니다.");
        } else {
            System.out.println("이미 등록된 책입니다.");
        }
    }

    // 도서삭제
    private void removeBook() {
        System.out.print("\n삭제할 책 ID를 입력하세요\n>> ");

        if (bookSv.removeBook(input.nextInt())) {
            System.out.println("삭제 되었습니다.");
        } else {
            System.out.println("등록된 책이 아닙니다.");
        }
        input.nextLine();
    }

}
