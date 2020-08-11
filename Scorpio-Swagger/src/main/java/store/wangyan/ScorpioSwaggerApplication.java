package store.wangyan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableOpenApi
@SpringBootApplication
@MapperScan(basePackages = {"store.wangyan.dao"})
public class ScorpioSwaggerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ScorpioSwaggerApplication.class);
    }
}
