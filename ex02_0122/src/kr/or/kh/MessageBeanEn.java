package kr.or.kh;

public class MessageBeanEn implements MessageBean {

	@Override
	public void call(String name) {
		System.out.println("Hello, "+name+"!");
	}
	// 강한결합관계에서 약한결합관계로 바뀐다.

}
