package kr.or.kh.six;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ConstructorCreationAcquisition {
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"src/kr/or/kh/b/ConstructorCreation.xml");
		ConstructorCreationService service = (ConstructorCreationService) context.getBean("service");
		service.Msg();
	}
}
