package com.example.demo.service;



import com.example.demo.dto.CustomerDTO;
import com.example.demo.entity.Customer;
import com.example.demo.exception.NotFoundException;
import com.example.demo.mapper.CustomerMapper;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // Lấy tất cả
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(CustomerMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Lấy theo ID
    public CustomerDTO getCustomerById(Integer id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id)); // Tái sử dụng NotFoundException
        return CustomerMapper.toDTO(customer);
    }

    // Tạo mới
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer customer = CustomerMapper.toEntity(customerDTO);
        Customer savedCustomer = customerRepository.save(customer);
        return CustomerMapper.toDTO(savedCustomer);
    }

    // Cập nhật
    public CustomerDTO updateCustomer(Integer id, CustomerDTO customerDTO) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));

        // Cập nhật thông tin
        customer.setCustomerName(customerDTO.getCustomerName());
        customer.setContactName(customerDTO.getContactName());
        customer.setAddress(customerDTO.getAddress());
        customer.setCity(customerDTO.getCity());
        customer.setPostalCode(customerDTO.getPostalCode());
        customer.setCountry(customerDTO.getCountry());

        Customer updatedCustomer = customerRepository.save(customer);
        return CustomerMapper.toDTO(updatedCustomer);
    }

    // Xóa
    public void deleteCustomer(Integer id) {
        if (!customerRepository.existsById(id)) {
            throw new NotFoundException(id);
        }
        customerRepository.deleteById(id);
    }
}