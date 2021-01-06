package com.springboot.sandbox.es.springbootsandboxes.elasticsearch;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class EsClient {

  @Value("${spring.elasticsearch.host}")
  private String host;

  @Value("${spring.elasticsearch.port}")
  private Integer port;

  @Value("${spring.elasticsearch.scheme}")
  private String scheme;

  @Bean(name = "EsClient", destroyMethod = "close")
  RestHighLevelClient getElasticsearchClient(){
    RestHighLevelClient restHighLevelClient =
        new RestHighLevelClient(
            RestClient.builder(
                new HttpHost(host, port, scheme))
        );
    return restHighLevelClient;
  }
}
