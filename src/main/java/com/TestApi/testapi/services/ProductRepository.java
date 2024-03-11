package com.TestApi.testapi.services;

import com.TestApi.testapi.tables.Product;
import com.TestApi.testapi.tables.UserProfile;
import org.apache.catalina.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product,String> {

    public Product findByProductName(String name);

}
