package pack.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pack.model.DataDao;
import pack.model.DataDaoImpl;

public class Main {
	public static void main(String[] args) {
		// 전통적 방법
		// DB처리용
		DataDaoImpl daoImpl = new DataDaoImpl(); // 싱글톤 패턴은 아니지만 스프링이 그 작업을 해줌
		DataDao dataDao = daoImpl;
		
		// 비즈니스 처리용
		BusinessServiceImpl businessServiceImpl = new BusinessServiceImpl(dataDao);
		BusinessService businessService = businessServiceImpl; // 부모클래스의 객체 주소에 자식의 파라미터 값을 넣어줘 결국에는 dataDto 호출하기 위함?
		businessService.selectProcess();
		
		System.out.println(" ------------- ");
		
		// spring 방법 : 환경설정(configuration) 파일(.xml)을 이용
		// 모든 객체 설정을 자바로부터 분리, 외부화 할 수 있다.
		// spring은 설정파일에서(ex:init.xml) 설정된 내용을 읽어 application에서 필요한 기능을 처리한다.
		// XML 기반으로 작성하나, 자바 클래스로 작성할 수도 있다.
		// Root tag는 <beans>다.
		// <bean> tag로 주입할 객체를 설정파일에 설정한다.
		// <bean>의 속성으로 id:객체변수명(중복 불가), name:복수의 이름 지정 가능
		
		/*
		// ApplicationContext context = new ClassPathXmlApplicationContext("init.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:init.xml");
		// ApplicationContext context = new ClassPathXmlApplicationContext("classpath:pack/controller/init.xml");
		// 다른경로에 있을경우 classpath:~~경로/파일명 형식으로 작성해주어야함
		BusinessService businessService2 = (BusinessService)context.getBean("businessServiceImpl");
		businessService2.selectProcess();
		*/
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		BusinessService businessService2 = (BusinessService)context.getBean("businessServiceImpl");
		businessService2.selectProcess();
	}
}
