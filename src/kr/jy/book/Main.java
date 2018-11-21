package kr.jy.book;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Library library = new Library();

        Scanner input = new Scanner(System.in);
        int actionType = 0;

        while(true) {
            System.out.print("[1]:책 검색  [2]:책 등록 [3]:책 삭제 [9]: 종료\n>> ");
            actionType = input.nextInt();
            input.nextLine();

            //책 검색
            if(actionType == 1) {
                System.out.print("검색할 책 제목을 입력하세요(빈 문자열 입력 시 모든 책 검색)\n>> ");
                List<Book> searchList = library.searchBook(input.nextLine());

                if(searchList.size() == 0) {
                    System.out.println("검색된 책이 없습니다.");
                } else {
                    for(Book book : searchList) {
                        System.out.printf("ID:%d, 제목:%s\n", book.getBookId(), book.getName());
                    }
                }

            //책 등록
            } else if(actionType == 2) {
                System.out.print("등록할 책 제목을 입력하세요\n>> ");

                if( library.addBook(new Book(input.nextLine())) ) {
                    System.out.println("책이 등록되었습니다.");
                } else {
                    System.out.println("이미 등록된 책입니다.");
                }

            //책 삭제
            } else if(actionType == 3) {
                System.out.print("삭제할 책 ID를 입력하세요\n>> ");

                if( library.removeBook(input.nextInt()) ) {
                    System.out.println("삭제 되었습니다.");
                } else {
                    System.out.println("등록된 책이 아닙니다.");
                }
                input.nextLine();

            //종료
            } else if(actionType == 9) {
                break;
            }
        }
    }
}
