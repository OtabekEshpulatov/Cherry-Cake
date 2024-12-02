package org.example.controller_api;

import org.example.logic.database.ProductsDAL;
import org.example.logic.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class productApi {
    private final ProductsDAL productsDAL;

    @Autowired
    public productApi(ProductsDAL productsDAL) {
        this.productsDAL = productsDAL;
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/all")
    public String getAllProductsAPI(){
        ProductService service=new ProductService(productsDAL);
        return service.getAllProducts();
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/top")
    public String getTopProducts(){
        ProductService service=new ProductService(productsDAL);
        return service.getTopProducts();
    }
}
