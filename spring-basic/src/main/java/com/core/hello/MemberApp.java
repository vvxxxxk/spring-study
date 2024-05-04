package com.core.hello;

import com.core.hello.member.Grade;
import com.core.hello.member.Member;
import com.core.hello.member.MemberService;
import com.core.hello.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {

        MemberService memberService = new MemberServiceImpl();

        // 회원 가입
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        // 회원 찾기
        Member findMember = memberService.findMember(1L);

        // 테스트
        System.out.println("join member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}

/*
    join member = memberA
    find member = memberA
*/