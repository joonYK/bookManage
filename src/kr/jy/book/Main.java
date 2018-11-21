package kr.jy.book;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Library library = new Library();

        Scanner input = new Scanner(System.in);
        int actionType = 0;
        int memberId = 0;
        int bookId = 0;

        while(true) {
            System.out.print("\n[1]:책 검색  [2]:책 등록  [3]:책 삭제  [4]:회원 검색  [5]:회원 등록  [6]:회원 삭제  [7]:책 대여  [8]:책 반납  [9]:종료\n>> ");
            actionType = input.nextInt();
            input.nextLine();

            //책 검색
            if(actionType == 1) {
                System.out.print("\n검색할 책 제목을 입력하세요(빈 문자열 입력 시 모든 책 검색)\n>> ");
                List<Book> searchList = library.searchBook(input.nextLine());

                if(searchList == null || searchList.size() == 0) {
                    System.out.println("검색된 책이 없습니다.");
                } else {
                    for(Book book : searchList) {
                        System.out.printf("ID:%d, 제목:%s, 대여상태:%s\n", book.getBookId(), book.getName(), book.isRental()?"O":"X");
                    }
                }

            //책 등록
            } else if(actionType == 2) {
                System.out.print("\n등록할 책 제목을 입력하세요\n>> ");

                if( library.addBook(new Book(input.nextLine())) ) {
                    System.out.println("책이 등록되었습니다.");
                } else {
                    System.out.println("이미 등록된 책입니다.");
                }

            //책 삭제
            } else if(actionType == 3) {
                System.out.print("\n삭제할 책 ID를 입력하세요\n>> ");

                if (library.removeBook(input.nextInt())) {
                    System.out.println("삭제 되었습니다.");
                } else {
                    System.out.println("등록된 책이 아닙니다.");
                }
                input.nextLine();

            //회원 검색
            } else if(actionType == 4) {
                System.out.print("\n검색할 회원 이름을 입력하세요(빈 문자열 입력 시 모든 회원 검색)\n>> ");
                List<Member> searchList = library.searchMember(input.nextLine());

                if(searchList == null || searchList.size() == 0) {
                    System.out.println("검색된 회원이 없습니다.");
                } else {
                    for(Member member : searchList) {
                        System.out.printf("ID:%d, 이름:%s, 대여리스트:%s\n", member.getMemberId(), member.getName(), "");
                    }
                }

            //회원 등록
            } else if(actionType == 5) {
                System.out.print("\n등록할 회원 이름을 입력하세요\n>> ");

                if( library.addMember(new Member(input.nextLine())) ) {
                    System.out.println("회원이 등록되었습니다.");
                } else {
                    System.out.println("이미 등록된 회원입니다.");
                }

            //회원 삭제
            } else if(actionType == 6) {
                System.out.print("\n삭제할 회원 ID를 입력하세요\n>> ");

                if (library.removeMember(input.nextInt())) {
                    System.out.println("삭제 되었습니다.");
                } else {
                    System.out.println("등록된 회원이 아닙니다.");
                }
                input.nextLine();

            //책 대여
            } else if(actionType == 7) {
                System.out.print("\n대여받을 회원 ID를 입력하세요\n>> ");
                memberId = input.nextInt();

                System.out.print("\n대여할 책 ID를 입력하세요\n>> ");
                bookId = input.nextInt();
                input.nextLine();

                if( library.rendBook(memberId, bookId) ) {
                    System.out.println("대여 완료 되었습니다.");
                } else {
                    System.out.println("대여할 수 없습니다.");
                }

            //책 반납
            } else if(actionType == 8) {
                System.out.print("\n반납할 회원 ID를 입력하세요\n>> ");

            //종료
            } else if(actionType == 9) {
                break;
            }
        }
    }
}
