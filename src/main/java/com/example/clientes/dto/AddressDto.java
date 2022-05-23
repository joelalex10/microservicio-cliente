package com.example.clientes.dto;

import javax.persistence.*;

public class AddressDto {
    private int addressId;
    private String address;
    private int postalCode;

    public AddressDto() {
    }

    public AddressDto(int addressId, String address, int postalCode) {
        this.addressId = addressId;
        this.address = address;
        this.postalCode = postalCode;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }
}
