package com.hibernate.jpa.hibernateJpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contact")
public class ContactInfo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long unid;
    private String city;
    private String phone;

    public long getUnid() {
        return unid;
    }

    public void setUnid(long unid) {
        this.unid = unid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
