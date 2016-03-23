package org.next;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("inpoker")
public class IndianPockerApplication {

	public static void main(String[] args) {
		SpringApplication.run(IndianPockerApplication.class, args);
	}
}
