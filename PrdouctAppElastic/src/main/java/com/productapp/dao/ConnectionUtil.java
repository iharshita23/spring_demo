package com.productapp.dao;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestClientBuilder.HttpClientConfigCallback;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;


public class ConnectionUtil {

    ElasticsearchClient elasticsearchClient;

 

    public static ElasticsearchClient getElasticClient() {

        final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();

        // provide crendentials to connect to elasticsearch

        credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials("elastic", "Harshita@23"));

 

        RestClientBuilder restClientBuilder = RestClient.builder(new HttpHost("localhost", 9200))

                .setHttpClientConfigCallback(new HttpClientConfigCallback() {

                    @Override

                    public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpClientBuilder) {

                        return httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);

                    }

                });

 

        // get the RestClient

        RestClient restClient = restClientBuilder.build();

 

        // Create the transport with a Jackson mapper

        ElasticsearchTransport transport = new RestClientTransport(restClient, new JacksonJsonpMapper());

 

        // And create the API client

        ElasticsearchClient esClient = new ElasticsearchClient(transport);

        return esClient;

    }

}