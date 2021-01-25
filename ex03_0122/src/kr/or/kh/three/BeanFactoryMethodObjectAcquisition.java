package kr.or.kh.three;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class BeanFactoryMethodObjectAcquisition {
	public static void main(String[] args) { 
		ApplicationContext context = new FileSystemXmlApplicationContext("src/kr/or/kh/three/BeanFactoryMethod.xml"); 
		BeanFactoryMethodCreation beanobj = (BeanFactoryMethodCreation) context.getBean("obj"); 

		beanobj.getMessage(); 
 }
}
