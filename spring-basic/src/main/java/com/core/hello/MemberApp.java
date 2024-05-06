package com.core.hello;

import com.core.hello.member.Grade;
import com.core.hello.member.Member;
import com.core.hello.member.MemberService;
import com.core.hello.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

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