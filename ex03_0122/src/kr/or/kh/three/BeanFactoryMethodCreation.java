package kr.or.kh.three;

public class BeanFactoryMethodCreation {

	private static BeanFactoryMethodCreation instance; // 싱글텀패턴

	public static BeanFactoryMethodCreation getInstance() {
		if (instance == null) {
			instance = new BeanFactoryMethodCreation();
		}
		return instance;
	}
	private BeanFactoryMethodCreation() { // 생성자함수를 private로 걸었으니 외부에서 사용할 수 없다
	}

	public void getMessage() {
		System.out.println("BeanFactoryMethodCreation.getMessage()....");
	}

}

// 객체를 단 하나만 만들 수 있다 
// 여러개를 만들 수 없다
// 이거를 우리는 자바에서 싱글턴패턴이라고 한다