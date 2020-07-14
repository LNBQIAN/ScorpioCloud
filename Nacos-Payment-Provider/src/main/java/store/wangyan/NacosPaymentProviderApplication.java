package store.wangyan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Administrator
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosPaymentProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(NacosPaymentProviderApplication.class,args);
    }
}
