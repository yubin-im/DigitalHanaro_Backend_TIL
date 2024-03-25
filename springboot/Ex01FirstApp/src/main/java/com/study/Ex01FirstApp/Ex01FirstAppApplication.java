package com.study.Ex01FirstApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
class MyConfig {
	// 웹 애플리케이션의 설정 정보를 담는 클래스
	@Bean
	public Student student() {
		System.out.println("bean generated");
		return new Student();
	}
}

class Student {
	String name = "Hong";
}

@SpringBootApplication
public class Ex01FirstAppApplication {

	public static void main(String[] args) {
		// 스프링 컨테이너에 등록된 빈 사용
		ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
		Student obj = (Student) context.getBean("student");
		System.out.println(obj.name);

		// 스프링 컨테이너에 등록된 빈 목록 출력
		String[] beanDefinitionNames = context.getBeanDefinitionNames();
		System.out.println(Arrays.toString(beanDefinitionNames));

		SpringApplication.run(Ex01FirstAppApplication.class, args);
	}

}
