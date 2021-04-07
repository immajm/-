package cn.lezu.consumer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Immajm
 * @time: 2021/3/27
 */

@EnableEurekaClient
@SpringBootApplication
@RestController
@MapperScan("cn.lezu.consumer.mapper")
public class LezuConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(LezuConsumerApplication.class, args);
    }

}
