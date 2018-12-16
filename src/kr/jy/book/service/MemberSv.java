package kr.jy.book.service;

import kr.jy.book.dataStructure.MyLinkedList;
import kr.jy.book.dto.Member;
import kr.jy.book.file.FileManage;
import kr.jy.book.file.ObjectFileManage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MemberSv {
    private static MemberSv instance;
    private MyLinkedList<Member> memberList = new MyLinkedList<Member>();
    private FileManage fileManage;
    private ObjectFileManage objectFileManage;

    public static MemberSv getInstance() {
        if(instance == null) instance = new MemberSv();
        return instance;
    }

    private MemberSv() {
        initData();
    }

    //데이터 초기화
    private void initData() {
        /*fileManage = new FileManage("member.txt");

        List<String> list = fileManage.readFile();
        for(String d : list) {
            String[] arr = d.split(",");
            memberList.add(new Member(arr[0].trim(), arr[1].trim(), arr[2].trim()));
        }*/

        objectFileManage = new ObjectFileManage("member.ser");
        memberList = (MyLinkedList<Member>)objectFileManage.readFile();

    }

    //회원 리스트
    public List<Member> searchMember(String memberName) {
        List<Member> searchMemberList = new ArrayList<Member>();

        for(int i=0; i<memberList.size(); i++) {
            if(memberName == null || memberName.equals("") || memberList.get(i).getName().contains(memberName)) {
                searchMemberList.add(memberList.get(i));
            }
        }

        return searchMemberList;
    }

    //회원 검색
    public Member searchMember(int memberId) {
        for(int i=0; i<memberList.size(); i++) {
            if(memberList.get(i).getMemberId() == memberId)
                return memberList.get(i);
        }

        return null;
    }

    //회원 등록
    public boolean addMember(Member addMember) {
       for(int i=0; i<memberList.size(); i++) {
           if(memberList.get(i).getMemberId() == addMember.getMemberId())
               return false;
       }

       memberList.add(addMember);
       return true;
    }

    //회원 삭제
    public boolean removeMember(int memberId) {
        for(int i=0; i<memberList.size(); i++) {
            if(memberList.get(i).getMemberId() == memberId) {
                memberList.remove(memberList.get(i));
                return true;
            }
        }

        return false;
    }

    public boolean saveMember() {
        //return fileManage.writeFile(memberList.toArray());
        return objectFileManage.writeFile(memberList);
    }

}