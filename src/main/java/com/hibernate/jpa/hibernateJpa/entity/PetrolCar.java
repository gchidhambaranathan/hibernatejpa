package com.hibernate.jpa.hibernateJpa.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "petrolcar")
/*@DiscriminatorValue("PETROL_CAR")*/
public class PetrolCar extends Car {

    private String fuelType;
    private String engine;

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }


}
