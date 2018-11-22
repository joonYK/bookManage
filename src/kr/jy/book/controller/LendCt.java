package kr.jy.book.controller;

import kr.jy.book.dto.Member;
import kr.jy.book.service.BookSv;
import kr.jy.book.service.MemberSv;

import java.util.Optional;
import java.util.Scanner;

public class LendCt {

    private MemberSv memberSv;
    private BookSv bookSv;
    private Scanner input = new Scanner(System.in);

    // 대여
    public void manage(MemberSv memberSv, BookSv bookSv) {
        this.memberSv = memberSv;
        this.bookSv = bookSv;
        int actionType = 0;

        while(true) {
            System.out.print("\n[1]:도서대여  [2]:도서반납 [9]:뒤로가기\n>> ");
            actionType = input.nextInt();
            input.nextLine();

            if(actionType == 1) {
                this.borrowBook();

            } else if(actionType == 2) {
                this.getBackBook();

            } else if(actionType == 9) {
                break;
            }
        }

    }

    //도서 대여
    private void borrowBook() {
        System.out.print("\n대여받을 회원 ID를 입력하세요\n>> ");

        Optional<Member> data = memberSv.searchMember(input.nextInt());
        if(!data.isPresent()) {
            System.out.println("회원이 존재하지 않습니다.");
            return;
        }

        System.out.print("\n대여할 책 ID를 입력하세요\n>> ");
        int bookId = input.nextInt();
        input.nextLine();

        if( bookSv.lendBook(data.get(), bookId) ) {
            System.out.println("대여 완료 되었습니다.");
        } else {
            System.out.println("대여할 수 없습니다.");
        }
    }

    //도서 반납
    private void getBackBook() {
        System.out.print("\n반납할 회원 ID를 입력하세요\n>> ");

        Optional<Member> data = memberSv.searchMember(input.nextInt());
        if(!data.isPresent()) {
            System.out.println("회원이 존재하지 않습니다.");
            return;
        }

        System.out.print("\n반납할 책 ID를 입력하세요\n>> ");
        int bookId = input.nextInt();
        input.nextLine();

        if( bookSv.getBackBook(data.get(), bookId) ) {
            System.out.println("반납 완료 되었습니다.");
        } else {
            System.out.println("반납할 수 없습니다.");
        }
    }
}
