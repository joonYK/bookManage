package kr.jy.book.controller;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import kr.jy.book.dto.Book;
import kr.jy.book.dto.Member;
import kr.jy.book.exception.LendBookException;
import kr.jy.book.service.BookSv;
import kr.jy.book.service.LendSv;
import kr.jy.book.service.MemberSv;

public class LendCt {

    private MemberSv memberSv = MemberSv.getInstance();
    private BookSv bookSv = BookSv.getInstance();
    private LendSv lendSv = LendSv.getInstance();
    private Scanner input = new Scanner(System.in);

    // 대여
    public void manage() {
        int actionType = 0;

        while(true) {
            System.out.print("\n[1]:도서대여  [2]:도서반납  [3]:로그  [9]:뒤로가기\n>> ");
            actionType = input.nextInt();
            input.nextLine();

            if(actionType == 1) {
                this.borrowBook();

            } else if(actionType == 2) {
                this.getBackBook();

            } else if(actionType == 3) {
                this.getLogList();

            } else if(actionType == 9) {
                break;
            }
        }

    }

    //도서 대여
    private void borrowBook() {
        System.out.print("\n대여받을 회원 ID, 대여할 책 ID를 입력하세요 ex)1,1\n>> ");
        Member memberData = memberSv.searchMember(input.nextInt());
        //Optional<Member> memberData = memberSv.searchMember(input.nextInt());
        /*if(!memberData.isPresent()) {
            System.out.println("회원이 존재하지 않습니다.");
            return;
        }*/

        if(memberData == null) {
            System.out.println("회원이 존재하지 않습니다.");
            return;
        }

        System.out.print("\n대여할 책 ID를 입력하세요\n>> ");
        Optional<Book> bookData = bookSv.searchBook(input.nextInt());
        if(!bookData.isPresent()) {
            System.out.println("책이 존재하지 않습니다.");
            return;
        }

        try {
            lendSv.lendBook(memberData, bookData.get());
            System.out.println("대여 완료 되었습니다.");
        }
        catch (LendBookException e) {
            handlerException(e);
        }
    }

    //도서 반납
    private void getBackBook() {
        System.out.print("\n반납할 회원 ID를 입력하세요\n>> ");
        Member memberData = memberSv.searchMember(input.nextInt());
        if(memberData == null) {
            System.out.println("회원이 존재하지 않습니다.");
            return;
        }
        /*Optional<Member> memberData = memberSv.searchMember(input.nextInt());
        if(!memberData.isPresent()) {
            System.out.println("회원이 존재하지 않습니다.");
            return;
        }*/

        System.out.print("\n반납할 책 ID를 입력하세요\n>> ");
        Optional<Book> bookData = bookSv.searchBook(input.nextInt());
        if(!bookData.isPresent()) {
            System.out.println("책이 존재하지 않습니다.");
            return;
        }

        try {
            lendSv.getBackBook(memberData, bookData.get());
            System.out.println("반납 완료 되었습니다.");

        } catch(LendBookException e) {
            handlerException(e);
        }
    }

    /**
     * 예외 처리
     * @param e
     */
    private void handlerException(LendBookException e) {
        if (e.getExceptionType () == LendBookException.LendBookExceptionType.IS_RENTAL)
            System.out.println("이미 대여중입니다.");
        else if (e.getExceptionType () == LendBookException.LendBookExceptionType.IS_RENTAL_NO)
            System.out.println("대여중인 책이 아닙니다.");
        else if (e.getExceptionType () == LendBookException.LendBookExceptionType.NO_BOOK)
            System.out.println("존재 하지 않는 책입니다.");
        else if (e.getExceptionType () == LendBookException.LendBookExceptionType.NO_MEMBER)
            System.out.println("존재 하지 않는 회원입니다.");
        else
            System.out.println("대여할 수 없습니다.");
    }

    /**
     * 로그 조회
     */
    public void getLogList() {
        List<String> logList = lendSv.getLogList();

        if(logList.size() == 0) {
            System.out.println("로그가 없습니다.");
            return;
        }

        logList.stream().forEach(log -> System.out.println(log));
    }

}
