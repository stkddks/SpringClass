package kr.or.kh.five;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class BeanConstructorArgCreationAcquisition {
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("src/kr/or/kh/five/BeanConstructorArg.xml");
		BeanConstructorArgCreation beanobj = (BeanConstructorArgCreation) context.getBean("obj");
		beanobj.printMessage();
	}
}
