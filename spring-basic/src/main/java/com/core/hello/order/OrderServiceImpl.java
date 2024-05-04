package com.core.hello.order;

import com.core.hello.discount.DiscountPolicy;
import com.core.hello.discount.FixDiscountPolicy;
import com.core.hello.member.Member;
import com.core.hello.member.MemberRepository;
import com.core.hello.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int disountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, disountPrice);
    }
}
