package hello.core.order;

import hello.core.discount.DisCountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
	
	private final MemberRepository memberRepository = new MemoryMemberRepository();
//	private final DisCountPolicy disCountPolicy = new FixDiscountPolicy();
	private final DisCountPolicy disCountPolicy = new RateDiscountPolicy();

	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		Member member = memberRepository.findById(memberId);
		int discouontPrice = disCountPolicy.discouont(member, itemPrice);
		
		return new Order(memberId, itemName, itemPrice, discouontPrice);
	}

}
