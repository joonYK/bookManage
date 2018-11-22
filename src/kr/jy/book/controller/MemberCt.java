package kr.jy.book.controller;

import kr.jy.book.dto.Member;
import kr.jy.book.service.Library;

import java.util.List;
import java.util.Scanner;

public class MemberCt {
    private Library library;
    private Scanner input = new Scanner(System.in);

    // 회원관리
    public void manage(Library library) {
        this.library = library;
        int actionType = 0;

        while(true) {
            System.out.print("\n[1]:회원 검색  [2]:회원 등록  [3]:회원 삭제 [9]:뒤로가기\n>> ");
            actionType = input.nextInt();
            input.nextLine();

            if(actionType == 1) {
                this.searchMember();

            } else if(actionType == 2) {
                this.addmember();

            } else if(actionType == 3) {
                this.removeMember();

            } else if(actionType == 9) {
                break;
            }
        }

    }

    // 회원검색
    private void searchMember() {
        System.out.print("\n검색할 회원 이름을 입력하세요(빈 문자열 입력 시 모든 회원 검색)\n>> ");
        List<Member> searchList = library.searchMember(input.nextLine());

        if(searchList == null || searchList.size() == 0) {
            System.out.println("검색된 회원이 없습니다.");
        } else {
            for(Member member : searchList) {
                System.out.printf("ID:%d, 이름:%s, 대여리스트:%s\n", member.getMemberId(), member.getName(), member.bookListToString());
            }
        }
    }

    // 회원등록
    private void addmember() {
        System.out.print("\n등록할 회원 이름을 입력하세요\n>> ");

        if( library.addMember(new Member(input.nextLine())) ) {
            System.out.println("회원이 등록되었습니다.");
        } else {
            System.out.println("이미 등록된 회원입니다.");
        }
    }

    // 회원삭제
    private void removeMember() {
        System.out.print("\n삭제할 회원 ID를 입력하세요\n>> ");

        if (library.removeMember(input.nextInt())) {
            System.out.println("삭제 되었습니다.");
        } else {
            System.out.println("등록된 회원이 아닙니다.");
        }
        input.nextLine();
    }
}
