package kr.jy.book;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Library library = new Library();

        Scanner input = new Scanner(System.in);
        int actionType = 0;

        while(true) {
            System.out.print("[1]:책 검색  [2]:책 등록 [9]: 종료\n>> ");
            actionType = input.nextInt();
            input.nextLine();

            if(actionType == 1) {
                System.out.print("검색할 책 제목을 입력하세요(빈 문자열 입력 시 모든 책 검색)\n>> ");
                library.searchBook(input.nextLine());

            } else if(actionType == 2) {
                System.out.print("제목을 입력하세요\n>> ");
                library.addBook(new Book(input.nextLine()));

            } else if(actionType == 9) {
                break;
            }
        }
    }
}
