package kr.or.kh;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;


public class HiSpring {

	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("src/kr/or/kh/beans.xml"));
		MessageBean bean = factory.getBean("messageBeanKr", MessageBean.class);
		bean.call("상아");
		bean = factory.getBean("messageBeanEn", MessageBean.class);
		bean.call("상아");
		
	}
}
// 의존관계 - 강한결합(일체형배터리 핸드폰), 약한결합(분리형배터리 핸드폰) 
// 스프링의 차이점이 뭔가요? 의 답변