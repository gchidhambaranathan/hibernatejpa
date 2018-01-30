package com.hibernate.jpa.hibernateJpa.entity;


import javax.persistence.Embeddable;


@Embeddable
public class Vehicle {
    private String vehiclieNo;
    private String vehicleType;
    private String brand;

    public String getVehiclieNo() {
        return vehiclieNo;
    }

    public void setVehiclieNo(String vehiclieNo) {
        this.vehiclieNo = vehiclieNo;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
