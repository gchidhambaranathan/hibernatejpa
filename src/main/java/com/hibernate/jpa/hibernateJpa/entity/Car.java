package com.hibernate.jpa.hibernateJpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "car")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
/*@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)*/
@Inheritance(strategy = InheritanceType.JOINED)
/*@DiscriminatorColumn(name = "car_type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("CAR")*/
public class Car {
    @Id @GeneratedValue(strategy = GenerationType.TABLE)
    private long unid;
    private String name;
    private String brand;

    public long getUnid() {
        return unid;
    }

    public void setUnid(long unid) {
        this.unid = unid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
