package hello.core.scope;

import static org.assertj.core.api.Assertions.assertThat;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import hello.core.scope.SingletonTest.SingletonBean;

public class PrototypeTest {
	
	@Test
	void prototypeBeanFind() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PtorotypeBean.class);
		System.out.println("find prototypeBean1");
		PtorotypeBean prototypeBean1 = ac.getBean(PtorotypeBean.class);
		System.out.println("find prototypeBean2");
		PtorotypeBean prototypeBean2 = ac.getBean(PtorotypeBean.class);
		
		System.out.println("prototypeBean1 = " + prototypeBean1);
		System.out.println("prototypeBean2 = " + prototypeBean2);
		
		assertThat(prototypeBean1).isNotSameAs(prototypeBean2);
		
		ac.close();
	}
	
	@Scope("prototype")
	static class PtorotypeBean {
		@PostConstruct
		public void init() {
			System.out.println("PtorotypeBean.init");
		}
		
		@PreDestroy
		public void destory() {
			System.out.println("PtorotypeBean.destroy");
		}
	}

}
