package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import java.time.LocalDate;

public class EmployeeDTO {

    private Integer id;

    @NotBlank(message = "Lastname is required")
    private String lastName;

    @NotBlank(message = "Firstname is required")
    private String firstName;

    @Past(message = "Birthdate must be in the past")
    private LocalDate birthDate;

    private Integer supervisorId;


    public EmployeeDTO() {
    }

    public EmployeeDTO(Integer id, String lastName, String firstName, LocalDate birthDate, Integer supervisorId) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.supervisorId = supervisorId;
    }



    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }
    public Integer getSupervisorId() { return supervisorId; }
    public void setSupervisorId(Integer supervisorId) { this.supervisorId = supervisorId; }
}