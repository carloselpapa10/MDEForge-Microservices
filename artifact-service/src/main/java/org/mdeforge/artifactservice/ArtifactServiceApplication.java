package org.mdeforge.artifactservice;

import org.mdeforge.artifactservice.commandhandlers.ArtifactServiceCommandHandlersConfiguration;
import org.mdeforge.artifactservice.dao.ArtifactServiceConfiguration;
import org.mdeforge.servicemodel.common.CommonSwaggerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import io.eventuate.jdbckafka.TramJdbcKafkaConfiguration;
import org.mdeforge.artifactservice.messaging.EventHandlersConfiguration;

@SpringBootApplication
@Import({ArtifactServiceConfiguration.class,
	ArtifactServiceCommandHandlersConfiguration.class,
	CommonSwaggerConfiguration.class,
	TramJdbcKafkaConfiguration.class, EventHandlersConfiguration.class})
public class ArtifactServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArtifactServiceApplication.class, args);
	}
}

