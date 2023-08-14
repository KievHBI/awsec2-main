package art.aws.ec2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@SpringBootApplication
public class Ec2Application {

	public static void main(String[] args) {
		SpringApplication.run(Ec2Application.class, args);
	}
}
