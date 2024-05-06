package com.core.hello;

import com.core.hello.discount.DiscountPolicy;
import com.core.hello.discount.FixDiscountPolicy;
import com.core.hello.discount.RateDiscountPolicy;
import com.core.hello.member.MemberRepository;
import com.core.hello.member.MemberService;
import com.core.hello.member.MemberServiceImpl;
import com.core.hello.member.MemoryMemberRepository;
import com.core.hello.order.OrderService;
import com.core.hello.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        // return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
}
