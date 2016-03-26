package core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("inpoker")
public class IndianPokerApplication {
	public static void main(String[] args) {
		SpringApplication.run(IndianPokerApplication.class, args);
	}
}
