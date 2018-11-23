package kr.jy.book;

import java.util.Scanner;

import kr.jy.book.controller.BookCt;
import kr.jy.book.controller.LendCt;
import kr.jy.book.controller.MemberCt;
import kr.jy.book.service.BookSv;
import kr.jy.book.service.MemberSv;

public class Main {

    public static void main(String[] args) {

        BookSv bookSv = new BookSv();
        MemberSv memberSv = new MemberSv();

        BookCt bookCt = new BookCt();
        MemberCt memberCt = new MemberCt(memberSv);
        LendCt lendCt = new LendCt();

        Scanner input = new Scanner(System.in);

        int actionType = 0;

        while(true) {

            System.out.print("\n[1]:도서관리  [2]:회원관리  [3]:대여관리  [9]:종료\n>> ");
            actionType = input.nextInt();
            input.nextLine();

            //도서관리
            if(actionType == 1) {
                bookCt.manage(bookSv);

            //회원 검색
            } else if(actionType == 2) {
                memberCt.manage();

            //대여관리
            } else if(actionType == 3) {
                lendCt.manage(memberSv, bookSv);

            //종료
            } else if(actionType == 9) {
                break;
            }
        }
    }
}
