package com.hibernate.jpa.hibernateJpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long unid;
    private String name;
    private String author;
    @ManyToMany(cascade = CascadeType.ALL, fetch =  FetchType.LAZY)
    private Set<Publisher> publishers = new HashSet<>();

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Set<Publisher> getPublishers() {
        return publishers;
    }

    public void setPublishers(Set<Publisher> publishers) {
        this.publishers = publishers;
    }
}
