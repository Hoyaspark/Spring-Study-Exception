package hello.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.thymeleaf.exceptions.TemplateInputException;

@SpringBootApplication
public class ExceptionApplication {

	public static void main(String[] args) {
			SpringApplication.run(ExceptionApplication.class, args);
	}

}
