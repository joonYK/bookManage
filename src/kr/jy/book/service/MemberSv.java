package kr.jy.book.service;

import kr.jy.book.dto.Member;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MemberSv {

    private static MemberSv instance;
    private LinkedList<Member> memberList = new LinkedList<> ();

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

        if(memberName == null || memberName.equals("")) {
            searchMemberList.addAll(memberList);
        } else {
            searchMemberList = memberList.stream().filter ( member -> member.getName().contains(memberName) ).collect(Collectors.toList());
        }

        return searchMemberList;
    }

    //회원 검색
    public Optional<Member> searchMember(int memberId) {
        return memberList.stream().filter(m -> m.getMemberId() == memberId).findFirst();
    }

    //회원 등록
    public boolean addMember(Member addMember) {
       if( memberList.stream().anyMatch(member -> member.getMemberId() == addMember.getMemberId()) ) {
           return false;
       }

       memberList.add(addMember);
       return true;
    }

    //회원 삭제
    public boolean removeMember(int memberId) {
        return memberList.removeIf(member -> member.getMemberId() == memberId);
    }


}