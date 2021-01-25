package kr.or.kh.seven;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class PropertySetAcquisition {
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("src/kr/or/kh/seven/PropertySet.xml");
		PropertySetService service = (PropertySetService) context.getBean("service");
		service.Meg();
	}
}