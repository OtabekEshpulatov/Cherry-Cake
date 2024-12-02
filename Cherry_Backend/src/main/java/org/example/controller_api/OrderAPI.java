package org.example.controller_api;

import org.example.logic.database.OrderDAL;
import org.example.logic.dto.OrderDto;
import org.example.logic.service.OrdersService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderAPI {
    private OrderDAL orderDAL;

    public OrderAPI(OrderDAL orderDAL) {
        this.orderDAL = orderDAL;
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/create")
    public String submitOrder(@RequestBody OrderDto orderDto){
        OrdersService service=new OrdersService(orderDAL);
        return service.submitOrder(orderDto);
    }
}
