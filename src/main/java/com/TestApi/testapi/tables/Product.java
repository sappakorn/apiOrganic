package com.TestApi.testapi.tables;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("product")
public class Product {
    private String productName;
    private String price;
    private String amount;
}
