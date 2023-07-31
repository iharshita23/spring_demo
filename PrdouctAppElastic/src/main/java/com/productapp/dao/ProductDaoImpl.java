package com.productapp.dao;

import java.util.List;
import java.util.stream.Collectors;

import com.productapp.model.Product;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.GetResponse;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;

public class ProductDaoImpl implements IProductDao{

	ElasticsearchClient esClient = ConnectionUtil.getElasticClient();

    @Override
    public String addProduct(Product product) throws Exception{
        IndexResponse response = 
                esClient.index(indexRequest->indexRequest.index("products")
                                    .id(product.getProductId())
                                    .document(product));
        System.out.println(response.result().name());
        return response.result().name();
    }

 

    @Override
    public Product findById(String productId) throws Exception{
        GetResponse<Product>  response = esClient.get(getRequest->
                                    getRequest.index("products")
                                    .id(productId), Product.class);
        if(response.found()) {
            Product product = response.source();
            return product;
        }
        return null;
    }

 

    @Override
    public List<Product> findAll() throws Exception {
//        SearchResponse<Product> response = esClient.search(
//                searchRequest->
//                    searchRequest.index("products")
//                            .query(query->query
//                            .matchAll(matchQuery->matchQuery.build()))
//                            , Product.class);
        return null;
    }

    @Override
    public List<Product> findByBrand(String brand) throws Exception {
        SearchResponse<Product> response = esClient.search(
                searchRequest->searchRequest.index("products")
                            .query(query->
                              query.match(matchquery->
                              matchquery.field("brand").query(brand))
                              )                
                ,Product.class);

        List<Hit<Product>> productHits = response.hits().hits();
        List<Product> products = productHits.stream()
                    .map(productHit->productHit.source()).collect(Collectors.toList());
        return products;
    }

 

    @Override
    public void updateProduct(String productId, Product product) throws Exception {
        esClient.update(updateRequest->
            updateRequest.index("products")
                        .id(productId)
                        .upsert(product)// if id not there create a new doc
        , Product.class);

    }

 

    @Override
    public void deleteProduct(String productId) throws Exception {
        esClient.delete(deleteRequest->
            deleteRequest.index("product")
                         .id(productId));

    }

 

}
