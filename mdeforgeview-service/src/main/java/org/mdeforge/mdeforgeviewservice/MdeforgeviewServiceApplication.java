package org.mdeforge.mdeforgeviewservice;

import org.mdeforge.mdeforgeviewservice.messaging.EventHandlersConfiguration;
import org.mdeforge.servicemodel.common.CommonSwaggerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import io.eventuate.jdbckafka.TramJdbcKafkaConfiguration;

@SpringBootApplication
@Import({EventHandlersConfiguration.class, CommonSwaggerConfiguration.class,  TramJdbcKafkaConfiguration.class})
public class MdeforgeviewServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MdeforgeviewServiceApplication.class, args);
	}
}

