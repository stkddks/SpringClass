package kr.or.kh;

public class MessageBeankr implements MessageBean {

	@Override
	public void call(String name) {
		System.out.println("안녕하세요, " + name + "씨!");
	}

}
