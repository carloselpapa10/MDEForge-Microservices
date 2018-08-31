package org.mdeforge.userservice;

import org.mdeforge.userservice.commandhandlers.UserServiceCommandHandlersConfiguration;
import org.mdeforge.userservice.dao.UserServiceConfiguration;
import org.mdeforge.servicemodel.common.CommonSwaggerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import io.eventuate.jdbckafka.TramJdbcKafkaConfiguration;

@SpringBootApplication
@Import({UserServiceConfiguration.class,
	UserServiceCommandHandlersConfiguration.class,
	CommonSwaggerConfiguration.class,
	TramJdbcKafkaConfiguration.class})
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}
}

