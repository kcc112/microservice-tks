package hex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = {"hex"})
public class ApplicationUserService {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationUserService.class, args);
	}
}
