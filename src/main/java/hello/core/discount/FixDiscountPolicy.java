package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DisCountPolicy {
	
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
