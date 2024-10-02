package ro.infrastructure.be;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@Slf4j
@EnableAsync
@SpringBootApplication
public class InfrastructureServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfrastructureServerApplication.class, args);
		log.info("InfrastructureBE started!");
	}
}
