package com.example.demo.service;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employee;
import com.example.demo.exception.NotFoundException;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;


    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(EmployeeMapper::toDTO) // [cite: 538]
                .collect(Collectors.toList());
    }

    public EmployeeDTO getEmployeeById(Integer id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id)); // [cite: 558]
        return EmployeeMapper.toDTO(employee);
    }

    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = EmployeeMapper.toEntity(employeeDTO);
        Employee createdEmployee = employeeRepository.save(employee);
        return EmployeeMapper.toDTO(createdEmployee);
    }

    public EmployeeDTO updateEmployee(Integer id, EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id)); // [cite: 581]


        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setBirthDate(employeeDTO.getBirthDate());
        employee.setSupervisorId(employeeDTO.getSupervisorId()); // Sửa thành SupervisorId

        Employee updatedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.toDTO(updatedEmployee);
    }

    public void deleteEmployee(Integer id) {
        if (!employeeRepository.existsById(id)) { // [cite: 606]
            throw new NotFoundException(id);
        }
        employeeRepository.deleteById(id);
    }
}