package hello.itemservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ItemServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemServiceApplication.class, args);
	}

	/*
	스프링에서 기본적으로 제공하는 기능으로 스프링부트를 사용하면 스프링 부트가 MessageSource를 빈으로 자동 등록한다.
	MessageSource는 인터페이스로 구현체인 ResourceBundleMessageSource를 스프링 빈으로 등록한다.
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new
				ResourceBundleMessageSource();
		messageSource.setBasenames("messages", "errors"); ->설정 파일의 이름을 지정(messages가 기본 설정). 파일 위치는 /resource/messages.properties
		messageSource.setDefaultEncoding("utf-8"); ->인코딩 정보 지정
		return messageSource;
	}*/

}
