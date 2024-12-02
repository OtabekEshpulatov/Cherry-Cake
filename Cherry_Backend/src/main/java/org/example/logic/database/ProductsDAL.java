package org.example.logic.database;

import com.google.gson.Gson;
import org.example.logic.dto.ProductDto;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Component
public class ProductsDAL {
    private DbConnection connection;
    public ProductsDAL(DbConnection connection){
        this.connection=connection;
    }
    public String AllProducts(){
        List <ProductDto> products=new ArrayList<>();
        Gson gson=new Gson();
        try(Connection connect= connection.getConnection()){
            String query="SELECT * FROM Products";
            PreparedStatement preparedStatement= connect.prepareStatement(query);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                ProductDto product=new ProductDto();
                product.setId(resultSet.getString(1));
                product.setName(resultSet.getString(2));
                product.setPicture(resultSet.getString(3));
                product.setAlt(resultSet.getString(4));
                product.setPrice(resultSet.getString(5));
                product.setRating(resultSet.getString(6));
                product.setDescription(resultSet.getString(7));
                product.setSize(resultSet.getString(8));
                products.add(product);
            }
            return gson.toJson(products);
        }catch (SQLException s){
            s.printStackTrace();
            return "500";
        }
    }
    public String TopProducts(){
        List <ProductDto> products=new ArrayList<>();
        Gson gson=new Gson();
        try(Connection connect= connection.getConnection()){
            String query="SELECT * FROM top_products";
            PreparedStatement preparedStatement= connect.prepareStatement(query);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                ProductDto product=new ProductDto();
                product.setId(resultSet.getString(1));
                product.setName(resultSet.getString(2));
                product.setPicture(resultSet.getString(3));
                product.setAlt(resultSet.getString(4));
                product.setPrice(resultSet.getString(5));
                product.setRating(resultSet.getString(6));
                product.setDescription(resultSet.getString(7));
                product.setSize(resultSet.getString(8));
                products.add(product);
            }
            return gson.toJson(products);
        }catch (SQLException s){
            s.printStackTrace();
            return "500";
        }
    }
}
