package org.example.logic.service;

import org.example.logic.database.OrderDAL;
import org.example.logic.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {
    private OrderDAL orderDAL;

    @Autowired
    public OrdersService(OrderDAL orderDAL) {
        this.orderDAL = orderDAL;
    }
    public String submitOrder(OrderDto orderDto){
        return orderDAL.registerOrder(orderDto);
    }
}
