package org.mdeforge.mdeforgeui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class MdeforgeUiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MdeforgeUiApplication.class, args);
	}

    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
        return new HiddenHttpMethodFilter();
    }

    @Bean
    public WebClient webClient(){
	    return WebClient.create();
    }
}
