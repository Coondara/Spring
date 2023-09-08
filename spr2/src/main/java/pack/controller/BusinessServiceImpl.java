package pack.controller;

import pack.model.DataDao;

public class BusinessServiceImpl implements BusinessService{
	
	private DataDao dataDao; // 다형성 사용... // 밑에 생성자를 통해서 인스턴스의 내용을 밀어 넣어 줄 수 있음 ex) 스포츠 경기 인터페이스? 
	/*
	public BusinessServiceImpl(){
		
	}
	*/
	public BusinessServiceImpl(DataDao dataDao) {
		// 생성자를 통해 DB처리용 영역 클래스의 객체 주소를 치환(injection (주입))
		this.dataDao = dataDao; 
	}
	
	@Override
	public void selectProcess() {
		// DB와 연결해 자료를 읽는 DataDaoImpl 클래스의 selectData 메소드 실행용
		dataDao.selectData(); // 부모 객체변수의 이름으로 뭘 어떻게 한다고?
	}

}
