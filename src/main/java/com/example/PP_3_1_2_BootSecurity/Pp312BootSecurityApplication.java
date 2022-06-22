package com.example.PP_3_1_2_BootSecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@SpringBootApplication
public class Pp312BootSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(Pp312BootSecurityApplication.class, args);
	}
	@Bean
	HiddenHttpMethodFilter hiddenHttpMethodFilter() {
		return new HiddenHttpMethodFilter();
	}


}
