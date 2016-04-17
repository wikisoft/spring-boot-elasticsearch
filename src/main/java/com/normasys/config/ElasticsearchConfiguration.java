package com.normasys.config;

import javax.annotation.Resource;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

//@Configuration
//@EnableElasticsearchRepositories(basePackages = "com.normasys.repository")
public class ElasticsearchConfiguration {

    @Value("${elasticsearch.host}")
    private String host;

    @Value("${elasticsearch.port}")
    private int port;

    @Resource
    private Environment environment;

    // @Bean
    public Client client() {
	TransportClient client = new TransportClient();
	TransportAddress address = new InetSocketTransportAddress(host, port);
	client.addTransportAddress(address);
	return client;
    }

    // @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
	return new ElasticsearchTemplate(client());
    }
}