package hello.core.member;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.core.AppConfig;
import hello.core.order.OrderService;

class MemberServiceTest {	
	
	MemberService memberService;
	
	@BeforeEach
	public void beforeEach() {
		AppConfig appConfig = new AppConfig();
		memberService = appConfig.memberService();
	}

	@Test
	void join() {
		// given
		Member member = new Member(1L, "memberA", Grade.VIP);
		
		// when
		memberService.join(member);
		Member findMember = memberService.findMember(1L);
		
		// then
		assertThat(member).isEqualTo(findMember);
	}

}
