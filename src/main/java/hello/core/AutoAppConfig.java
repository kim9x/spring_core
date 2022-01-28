package hello.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

@Configuration
@ComponentScan(
//		basePackages = "hello.core.member",
//		basePackageClasses = AutoAppConfig.class,
		excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
		)
public class AutoAppConfig {
	
//	@Autowired MemberRepository memberRepository;
//	@Autowired DiscountPolicy discountPolicy;
	
//	@Bean
//	OrderService orderSerivce() {
//		return new OrderServiceImpl(memberRepository, discountPolicy);
//	}
	
	@Bean(name = "memoryMemberRepository")
	MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}

}
