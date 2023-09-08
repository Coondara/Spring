package pack.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pack.model.DataDaoImpl;

@Configuration
public class Config {
	// 객체 환경 설정 파일 (**.xml) 대신 클래스로 객체 환경설정을 할 수 있다.
	
	public DataDaoImpl dataDaoImpl() {
		DataDaoImpl dataDaoImpl = new DataDaoImpl();
		return dataDaoImpl;
	}
	
	@Bean
	public BusinessServiceImpl businessServiceImpl() {
		BusinessServiceImpl businessServiceImpl = new BusinessServiceImpl(dataDaoImpl());
		return businessServiceImpl;
	}
	
}
