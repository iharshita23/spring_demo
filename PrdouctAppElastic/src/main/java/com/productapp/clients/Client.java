package com.productapp.clients;

import java.io.IOException;

import com.productapp.dao.ConnectionUtil;
import com.productapp.model.Product;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.ElasticsearchException;
import co.elastic.clients.elasticsearch.core.IndexResponse;

public class Client {
public static void main(String[] args) throws ElasticsearchException,IOException{
	//get the es client
	ElasticsearchClient elasticsearchClient = ConnectionUtil.getElasticClient();
	
	//create the index
//	Product product = new Product("Mobile","P001",1200,"Samsung","Electronics");
//	IndexResponse response = elasticsearchClient.index(
//			indexRequest->{
//				return indexRequest.index("products")
//						.id(product.getProductId())
//						.document(product);});
//	System.out.println(response.result().name());
	elasticsearchClient.indices().create(createRequest->createRequest.index("vehicles"));
		              
}
}
