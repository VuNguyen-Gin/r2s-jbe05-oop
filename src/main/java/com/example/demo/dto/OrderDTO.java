package com.example.demo.dto;


import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class OrderDTO {

    private Integer id;

    @NotNull(message = "Order date is required")
    private LocalDateTime orderDate;


    @NotNull(message = "Employee ID is required")
    private Integer employeeId;

    @NotNull(message = "Customer ID is required")
    private Integer customerId;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}