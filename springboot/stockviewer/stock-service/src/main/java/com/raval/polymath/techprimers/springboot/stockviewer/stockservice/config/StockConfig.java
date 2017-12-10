package com.raval.polymath.techprimers.springboot.stockviewer.stockservice.config;

//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
//@EnableEurekaClient
public class StockConfig {

  @Bean
  public RestTemplate getRestTemplate(){
    return new RestTemplate();
  }
}