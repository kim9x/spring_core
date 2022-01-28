package hello.core.order;

import org.springframework.stereotype.Component;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
	
	private final MemberRepository memberRepository;
	private final DiscountPolicy disCountPolicy;
	
//	@Autowired
//	public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy disCountPolicy) {
//		this.memberRepository = memberRepository;
//		this.disCountPolicy = disCountPolicy;
//	}

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
