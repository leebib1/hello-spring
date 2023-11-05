package hello.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoreApplication {
	public static void main(String[] args) {
		//에노테이션 기반의 자바 설정 클래스로 스프링 컨테이너를 생성한 방법
		SpringApplication.run(CoreApplication.class, args);
	}
}
