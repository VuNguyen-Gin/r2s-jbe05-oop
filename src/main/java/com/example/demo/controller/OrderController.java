package com.example.demo.controller;


import com.example.demo.dto.OrderDTO;
import com.example.demo.dto.OrderDetails;
import com.example.demo.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        List<OrderDTO> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable int id) {
        OrderDTO order = orderService.getOrderById(id);
        return ResponseEntity.ok(order);
    }

    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@Valid @RequestBody OrderDTO orderDTO) {
        OrderDTO createdOrder = orderService.createOrder(orderDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDTO> updateOrder(@PathVariable int id, @Valid @RequestBody OrderDTO updatedOrderDTO) {
        OrderDTO updatedOrder = orderService.updateOrder(id, updatedOrderDTO);
        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable int id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }



    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<OrderDetails>> getOrdersByEmployeeId(@PathVariable("employeeId") Integer id) {
        List<OrderDetails> orders = orderService.getOrdersWithEmployeeDetails(id);
        return ResponseEntity.ok(orders);
    }


    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<OrderDTO>> getOrdersByCustomerId(@PathVariable("customerId") Integer id) {
        List<OrderDTO> orders = orderService.getOrdersByCustomerId(id);
        return ResponseEntity.ok(orders);
    }

}