package kr.or.kh.six;

public class ConstructorCreationService {
	private ConstructorCreation ConstructorObj; // 기본 생성자

	public ConstructorCreationService() {
	} // 생성자를 통해 ConstructorObj를 획득

	public ConstructorCreationService(ConstructorCreation ConstructorObj) {
		this.ConstructorObj = ConstructorObj;
	}

	public void Msg() {
		ConstructorObj.insert();
		ConstructorObj.delete();
	}
}
