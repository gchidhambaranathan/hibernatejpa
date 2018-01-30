package com.hibernate.jpa.hibernateJpa.entity;


import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "person")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Person {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long unid;
    private String name;
    private String gender;
    private int age;

    @Embedded
     private Address primaryAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "sec_street")),
            @AttributeOverride(name = "city", column = @Column(name = "sec_city")),
            @AttributeOverride(name = "pincode", column = @Column(name = "sec_pincode"))
    })
    private Address secondaryAddress;


    @ElementCollection
    private List<Vehicle> vehicles = new ArrayList<>();

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(Address primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    public Address getSecondaryAddress() {
        return secondaryAddress;
    }

    public void setSecondaryAddress(Address secondaryAddress) {
        this.secondaryAddress = secondaryAddress;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
