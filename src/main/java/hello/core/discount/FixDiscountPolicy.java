package hello.core.discount;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import hello.core.member.Grade;
import hello.core.member.Member;

@Component
//@Qualifier("fixDiscountPolicy")
//@Primary
public class FixDiscountPolicy implements DiscountPolicy {
	
	private int discountFixAmount = 1000; // 1000원 할인

	@Override
	public int discouont(Member member, int price) {
		// enum 타입은 아래처럼 '==' 사용하는 것이 맞음.
		if (member.getGrade() == Grade.VIP) {
			return discountFixAmount;
		} else {
			return 0;			
		}
	}
	

}
