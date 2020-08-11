package store.wangyan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableOpenApi
@SpringBootApplication(scanBasePackages = {"store.wangyan.web.*"})
public class ScorpioAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(ScorpioAdminApplication.class);
    }
}
