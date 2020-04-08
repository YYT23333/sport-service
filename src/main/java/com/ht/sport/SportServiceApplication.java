package com.ht.sport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableHystrix
@EnableFeignClients
@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
@EnableJpaRepositories("com.ht.sport.dao")
@ComponentScan(basePackages = {"com.ht.sport.controller", "com.ht.sport.serviceImpl", "com.ht.sport.dataServiceImpl"})//手动指定bean组件扫描范围
public class SportServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SportServiceApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
    }
}
