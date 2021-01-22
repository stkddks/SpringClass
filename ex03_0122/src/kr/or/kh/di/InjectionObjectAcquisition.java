package kr.or.kh.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class InjectionObjectAcquisition {
	public static void main(String[] args) {
//스프링컨테이너가 있는 자원의 경로 지정
		ApplicationContext context = new FileSystemXmlApplicationContext("src/min/chap ter/three/Injection.xml");
		// 스프링컨테이너의
		// bean
		// 객체
		// 획득
		InjectionInterface obj = (InjectionInterface) context.getBean("service");
		System.out.println("START.....");
		obj.printMessage();
		System.out.println("END.....");
	}
}
