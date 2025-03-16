package com.sfood.api;

import com.sfood.dto.other_dto.CheckOutOrder;
import com.sfood.service.impl.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OrderAPI {

    @Autowired
    private OrderService orderService;

    @PostMapping("/order/checkout")
    public ResponseEntity<?> checkout(@RequestBody CheckOutOrder checkOutOrder) {
        try {
            orderService.processCheckOut(checkOutOrder);
            return ResponseEntity.ok("Order place successfully");
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }
}
