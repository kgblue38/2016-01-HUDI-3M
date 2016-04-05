package core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

import core.mail.JavaMailAuthenticator;
import core.mail.MimeMailSender;

@Configuration
public class MailConfig {
	
	@Bean
	public JavaMailAuthenticator javaMailSender() {
		JavaMailAuthenticator javaMailAuthenticator = new JavaMailAuthenticator();
		javaMailAuthenticator.setHost("smtp.gmail.com");
		javaMailAuthenticator.setPort(465);
		javaMailAuthenticator.setProtocol("smtps");
		javaMailAuthenticator.setUsername("dlseldjs3m@gmail.com");
		javaMailAuthenticator.setPassword("dlseldjs");
		
		return javaMailAuthenticator;
	}
	
	@Bean
	public MimeMailSender mimeMailSender() {
		MimeMailSender mimeMailSender = new MimeMailSender();
		// 빈 안에서 다른 빈 가져올때 이렇게 가져와도 되나..
		mimeMailSender.setSender(javaMailSender());
		return mimeMailSender;
	}
}
