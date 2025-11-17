package com.example.demo.repository;


import com.example.demo.dto.OrderDetails;
import com.example.demo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {


    List<Order> findByEmployee_Id(int employeeId);

    @Query("SELECT new com.example.demo.dto.OrderDetails(o.id, o.orderDate, e.id, e.lastName, e.firstName) " +
            "FROM Order o " +
            "JOIN o.employee e " +
            "WHERE e.id = :employeeId")
    List<OrderDetails> findAllOrdersWithEmployeeDetails(int employeeId);



    List<Order> findByCustomer_Id(int customerId);

}