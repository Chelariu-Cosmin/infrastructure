package ro.infrastructure.be;

import org.springframework.boot.SpringApplication;

public class TestInfrastructureServerApplication {

	public static void main(String[] args) {
		SpringApplication.from(InfrastructureServerApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
