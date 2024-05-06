package com.core.hello.order;

import com.core.hello.discount.DiscountPolicy;
import com.core.hello.discount.FixDiscountPolicy;
import com.core.hello.member.Member;
import com.core.hello.member.MemberRepository;
import com.core.hello.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(@Qualifier("memoryMemberRepository") MemberRepository memberRepository, @Qualifier("rateDiscountPolicy") DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int disountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, disountPrice);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
