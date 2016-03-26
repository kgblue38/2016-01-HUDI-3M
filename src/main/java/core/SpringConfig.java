package core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

	@Bean
	public UserRepository userrepository() {
		return new UserRepository();

	}

}
