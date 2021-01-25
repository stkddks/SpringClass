package kr.or.kh.five;

public class BeanConstructorArgCreation {
	private String msg; // 기본 생성자 생성

	public BeanConstructorArgCreation() {
	};

	public BeanConstructorArgCreation(String msg) { // 매개변수가 존재하는 생성자 생성
		this.msg = msg;
	}

	public void printMessage() {
		System.out.println("BeanConstructorArgCreation.msg의 내용 : " + msg);
	}
}
