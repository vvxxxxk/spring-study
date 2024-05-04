package com.core.hello.order;

import com.core.hello.member.MemberRepository;

public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice);
}
