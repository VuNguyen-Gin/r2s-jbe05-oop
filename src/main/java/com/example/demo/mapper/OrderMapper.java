package com.example.demo.mapper;



import com.example.demo.dto.OrderDTO;
import com.example.demo.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface OrderMapper {


    @Mapping(target = "employeeId", source = "employee.id")

    @Mapping(target = "customerId", source = "customer.id")
    @Mapping(target = "orderDate", source = "orderDate")

    OrderDTO toDTO(Order order);


    @Mapping(target = "employee.id", source = "employeeId")

    @Mapping(target = "customer.id", source = "customerId")
    @Mapping(target = "orderDate", source = "orderDate")

    Order toEntity(OrderDTO orderDTO);
}