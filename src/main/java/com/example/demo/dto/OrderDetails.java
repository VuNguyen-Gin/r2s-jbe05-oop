package com.example.demo.dto;

import java.time.LocalDateTime;


public class OrderDetails {
    private Integer orderId;
    private LocalDateTime orderDate;
    private Integer employeeId;
    private String employeeLastName;
    private String employeeFirstName;


    public OrderDetails(Integer orderId, LocalDateTime orderDate, Integer employeeId, String employeeLastName, String employeeFirstName) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.employeeId = employeeId;
        this.employeeLastName = employeeLastName;
        this.employeeFirstName = employeeFirstName;
    }


    public Integer getOrderId() { return orderId; }
    public LocalDateTime getOrderDate() { return orderDate; }
    public Integer getEmployeeId() { return employeeId; }
    public String getEmployeeLastName() { return employeeLastName; }
    public String getEmployeeFirstName() { return employeeFirstName; }
}