package com.core.hello.discount;

import com.core.hello.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);
}
