package com.core.hello;

import com.core.hello.member.Grade;
import com.core.hello.member.Member;
import com.core.hello.member.MemberService;
import com.core.hello.member.MemberServiceImpl;
import com.core.hello.order.Order;
import com.core.hello.order.OrderService;
import com.core.hello.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {

        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice() = " + order.calculatePrice());
    }
}
