package com.example.demo.mapper;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employee;

public class EmployeeMapper {


    public static EmployeeDTO toDTO(Employee employee) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(employee.getId()); // PDF đã bỏ quên ID, nhưng chúng ta nên thêm vào
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setBirthDate(employee.getBirthDate());
        dto.setSupervisorId(employee.getSupervisorId()); // Sửa thành SupervisorId
        return dto;
    }


    public static Employee toEntity(EmployeeDTO dto) {
        Employee employee = new Employee();
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setBirthDate(dto.getBirthDate());
        employee.setSupervisorId(dto.getSupervisorId()); // Sửa thành SupervisorId
        return employee;
    }
}