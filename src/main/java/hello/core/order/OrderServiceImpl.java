package hello.core.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

@Component
public class OrderServiceImpl implements OrderService {
	
//	private final MemberRepository memberRepository;
//	private final DiscountPolicy disCountPolicy;
	
//	private MemberRepository memberRepository;
//	private DiscountPolicy disCountPolicy;	
	
//	@Autowired
	private final MemberRepository memberRepository;
	
//	@Autowired
	private final DiscountPolicy disCountPolicy;
	
//	@Autowired
//	public void setMemberRepository(MemberRepository memberRepository) {
//		this.memberRepository = memberRepository;
//	}
//	
//	@Autowired
//	public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//		this.disCountPolicy = discountPolicy;
//	}
	
	@Autowired
	public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy disCountPolicy) {
		this.memberRepository = memberRepository;
		this.disCountPolicy = disCountPolicy;
	}

	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		Member member = memberRepository.findById(memberId);
		int discouontPrice = disCountPolicy.discouont(member, itemPrice);
		
		return new Order(memberId, itemName, itemPrice, discouontPrice);
	}
	
	// 테스트 용도
	public MemberRepository getMemberRepository() {
		return memberRepository;
	}
 
}
