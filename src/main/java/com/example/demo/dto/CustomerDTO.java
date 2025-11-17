package com.example.demo.dto;


import jakarta.validation.constraints.NotBlank;

public class CustomerDTO {

    private Integer id;

    @NotBlank(message = "Customer name is required") // Validate vì cột này not null
    private String customerName;

    private String contactName;
    private String address;
    private String city;
    private String postalCode;
    private String country;

    // --- Constructors ---
    public CustomerDTO() {
    }

    public CustomerDTO(Integer id, String customerName, String contactName, String address, String city, String postalCode, String country) {
        this.id = id;
        this.customerName = customerName;
        this.contactName = contactName;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }


    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public String getContactName() { return contactName; }
    public void setContactName(String contactName) { this.contactName = contactName; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getPostalCode() { return postalCode; }
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
}