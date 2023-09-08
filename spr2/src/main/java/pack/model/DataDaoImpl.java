package pack.model;

public class DataDaoImpl implements DataDao{
	@Override // 이거 역시도 하나의 메소드임
	public void selectData() {
		System.out.println("DB와 연결한 후 selectData 수행");
		
	}
}
