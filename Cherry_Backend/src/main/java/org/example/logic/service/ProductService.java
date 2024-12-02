package org.example.logic.service;

import org.example.logic.database.ProductsDAL;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private ProductsDAL productsDAL;
    public ProductService(ProductsDAL productsDAL) {
        this.productsDAL = productsDAL;
    }
    public String getAllProducts(){
        return productsDAL.AllProducts();
    }
    public String getTopProducts(){
        return productsDAL.TopProducts();
    }
}
