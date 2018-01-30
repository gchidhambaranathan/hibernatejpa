package com.hibernate.jpa.hibernateJpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employer")
public class Employer {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long unid;
    private String name;
    private String location;

    @OneToMany(cascade = CascadeType.ALL/*, mappedBy = "employer"*/,orphanRemoval = true)
   /* @JoinColumn(name = "employer_id")*/
    private Set<Employee> employees = new HashSet<>();

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
