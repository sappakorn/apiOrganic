package com.TestApi.testapi.controller;

import com.TestApi.testapi.services.ProductRepository;
import com.TestApi.testapi.tables.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/save")
    public Object addproduct(@RequestBody Product product){
        APIResponse res = new APIResponse();
        res.setStatus(1);
        productRepository.save(product);
        return res;
    }

    @PostMapping("/product-list")
    public Object showproduct(){
        APIResponse res = new APIResponse();
        List<Product> db = productRepository.findAll();
        res.setStatus(1);
        res.setData(db);

        return res;
    }

    @PostMapping("showbyname")
    public Object showbyname(@RequestBody String name){
        APIResponse res = new APIResponse();
        Product db = productRepository.findByProductName(name);
        if(db==null){
            res.setStatus(0);
            res.setMessage("No product");
        }else {
            res.setStatus(1);
            res.setData(db);
        }

        return res;
    }
}
