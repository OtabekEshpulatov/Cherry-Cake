package org.example.logic.database;

import org.example.logic.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class OrderDAL {
    private DbConnection dbConnection;

    @Autowired
    public OrderDAL(DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }
    public String registerOrder(OrderDto order){
        try(Connection connection= dbConnection.getConnection()) {
            String query="INSERT INTO product_orders (quantity, region, date, price, \"userid_Users\") values (?, ?, ?, ?, ?)";
            PreparedStatement statement= connection.prepareStatement(query);
            statement.setInt(1,Integer.parseInt(order.getQuantity()));
            statement.setString(2,order.getRegion());
            statement.setString(3,order.getDate());
            statement.setString(4,order.getPrice());
            statement.setInt(5,Integer.parseInt(order.getUserid()));
            statement.executeUpdate();
            return "ok";
        }catch (SQLException s){
            s.printStackTrace();
            return "ko";
        }
    }
}