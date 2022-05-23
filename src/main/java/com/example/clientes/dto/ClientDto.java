package com.example.clientes.dto;

public class ClientDto {
    private Integer clientId;
    private String name;
    private String lastname;
    private String email;
    private Integer phone;
    private int addressId;

    public ClientDto(Integer clientId, String name, String lastname, String email, Integer phone, int addressId) {
        this.clientId = clientId;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.addressId = addressId;
    }

    public ClientDto(){

    }
    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }
}
