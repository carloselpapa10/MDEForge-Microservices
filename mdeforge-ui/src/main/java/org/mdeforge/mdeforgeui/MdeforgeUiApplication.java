package org.mdeforge.mdeforgeui;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeFilterFunctions;
import org.springframework.web.reactive.function.client.WebClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class MdeforgeUiApplication {

    private static final Logger logger = LoggerFactory.getLogger(MdeforgeUiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MdeforgeUiApplication.class, args);
	}

    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
        return new HiddenHttpMethodFilter();
    }

    @Value("${apigateway.service.url}")
    private String apigateway_service_url;

	@Value("${apigateway.user}")
    private String apigateway_service_user;

	@Value("${apigateway.pass}")
    private String apigateway_service_pass;

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl(apigateway_service_url)
                .filter(ExchangeFilterFunctions
                        .basicAuthentication(apigateway_service_user, apigateway_service_pass))
                .filter(logRequest())
                .build();
    }

    /* looging requets*/
    private ExchangeFilterFunction logRequest() {
        return (clientRequest, next) -> {
            logger.info("Request: {} {}", clientRequest.method(), clientRequest.url());
            clientRequest.headers()
                    .forEach((name, values) -> values.forEach(value -> logger.info("{}={}", name, value)));
            return next.exchange(clientRequest);
        };
    }

}
