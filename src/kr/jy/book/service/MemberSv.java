package kr.jy.book.service;

import kr.jy.book.dataStructure.MyLinkedList;
import kr.jy.book.dto.Member;

import java.util.ArrayList;
import java.util.List;

public class MemberSv {

    private static MemberSv instance;
    private MyLinkedList<Member> memberList = new MyLinkedList<Member>();

    public static MemberSv getInstance() {
        if(instance == null) instance = new MemberSv();
        return instance;
    }

    private MemberSv() {
        memberList.add(new Member("준엽"));
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

    /*//회원 검색
    public Optional<Member> searchMember(int memberId) {
        return memberList.stream().filter(m -> m.getMemberId() == memberId).findFirst();
    }*/

    //회원 검색
    public Member searchMember(int memberId) {
        for(int i=0; i<memberList.size(); i++) {
            if(memberList.get(i).getMemberId() == memberId)
                return memberList.get(i);
        }

        return null;
        //return memberList.stream().filter(m -> m.getMemberId() == memberId).findFirst();
    }

    //회원 등록
    public boolean addMember(Member addMember) {
       for(int i=0; i<memberList.size(); i++) {
           if(memberList.get(i).getMemberId() == addMember.getMemberId())
               return false;
       }

       /*if( memberList.stream().anyMatch(member -> member.getMemberId() == addMember.getMemberId()) ) {
            return false;
       }*/

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
//        return memberList.removeIf(member -> member.getMemberId() == memberId);
    }


}