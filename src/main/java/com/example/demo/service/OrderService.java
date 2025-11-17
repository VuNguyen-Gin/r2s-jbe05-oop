package com.example.demo.service;


import com.example.demo.dto.OrderDTO;
import com.example.demo.dto.OrderDetails;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Order;
import com.example.demo.exception.NotFoundException;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final EmployeeRepository employeeRepository;


    private final CustomerRepository customerRepository;


    @Autowired
    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper,
                        EmployeeRepository employeeRepository,
                        CustomerRepository customerRepository) { // CẬP NHẬT: Thêm vào constructor
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.employeeRepository = employeeRepository;
        this.customerRepository = customerRepository; // CẬP NHẬT
    }


    public List<OrderDTO> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map(orderMapper::toDTO).collect(Collectors.toList());
    }

    public OrderDTO getOrderById(int id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
        return orderMapper.toDTO(order);
    }



    public OrderDTO createOrder(OrderDTO orderDTO) {
        Order order = orderMapper.toEntity(orderDTO);


        Employee employee = employeeRepository.findById(orderDTO.getEmployeeId())
                .orElseThrow(() -> new NotFoundException(orderDTO.getEmployeeId()));


        Customer customer = customerRepository.findById(orderDTO.getCustomerId())
                .orElseThrow(() -> new NotFoundException(orderDTO.getCustomerId()));

        order.setEmployee(employee);
        order.setCustomer(customer);

        return orderMapper.toDTO(orderRepository.save(order));
    }




    public OrderDTO updateOrder(int id, OrderDTO orderDTO) {

        Order orderToUpdate = orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));


        orderToUpdate.setOrderDate(orderDTO.getOrderDate());


        Employee employee = employeeRepository.findById(orderDTO.getEmployeeId())
                .orElseThrow(() -> new NotFoundException(orderDTO.getEmployeeId()));


        Customer customer = customerRepository.findById(orderDTO.getCustomerId())
                .orElseThrow(() -> new NotFoundException(orderDTO.getCustomerId()));

        orderToUpdate.setEmployee(employee);
        orderToUpdate.setCustomer(customer);

        return orderMapper.toDTO(orderRepository.save(orderToUpdate));
    }



    public void deleteOrder(int id) {
        if (!orderRepository.existsById(id)) {
            throw new NotFoundException(id);
        }
        orderRepository.deleteById(id);
    }


    public List<OrderDTO> getOrdersByEmployeeId(Integer employeeId) {
        List<Order> orders = orderRepository.findByEmployee_Id(employeeId);
        return orders.stream().map(orderMapper::toDTO).collect(Collectors.toList());
    }

    public List<OrderDetails> getOrdersWithEmployeeDetails(Integer employeeId) {
        return orderRepository.findAllOrdersWithEmployeeDetails(employeeId);
    }



    public List<OrderDTO> getOrdersByCustomerId(Integer customerId) {
        List<Order> orders = orderRepository.findByCustomer_Id(customerId);
        return orders.stream().map(orderMapper::toDTO).collect(Collectors.toList());
    }

}