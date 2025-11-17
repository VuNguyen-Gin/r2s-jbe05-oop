package com.example.demo.mapper;


import com.example.demo.dto.CustomerDTO;
import com.example.demo.entity.Customer;

public class CustomerMapper {

    // Entity -> DTO
    public static CustomerDTO toDTO(Customer customer) {
        CustomerDTO dto = new CustomerDTO();
        dto.setId(customer.getId());
        dto.setCustomerName(customer.getCustomerName());
        dto.setContactName(customer.getContactName());
        dto.setAddress(customer.getAddress());
        dto.setCity(customer.getCity());
        dto.setPostalCode(customer.getPostalCode());
        dto.setCountry(customer.getCountry());
        return dto;
    }

    // DTO -> Entity
    public static Customer toEntity(CustomerDTO dto) {
        Customer customer = new Customer();

        customer.setCustomerName(dto.getCustomerName());
        customer.setContactName(dto.getContactName());
        customer.setAddress(dto.getAddress());
        customer.setCity(dto.getCity());
        customer.setPostalCode(dto.getPostalCode());
        customer.setCountry(dto.getCountry());
        return customer;
    }
}