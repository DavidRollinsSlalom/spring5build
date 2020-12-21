package com.guru.example.rollinsbuild.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String address1;
    private String city;
    private String state;
    private String zipCode;

    @OneToMany
    @JoinColumn(name="publisher_id")
    private Set<Book> books = new HashSet<>();

    public Publisher() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Publisher)) return false;
        Publisher publisher = (Publisher) o;
        return Objects.equals(getId(), publisher.getId()) && Objects.equals(getName(), publisher.getName()) && Objects.equals(getAddress1(), publisher.getAddress1()) && Objects.equals(getCity(), publisher.getCity()) && Objects.equals(getState(), publisher.getState()) && Objects.equals(getZipCode(), publisher.getZipCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAddress1(), getCity(), getState(), getZipCode());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Publisher.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("address1='" + address1 + "'")
                .add("city='" + city + "'")
                .add("state='" + state + "'")
                .add("zipCode='" + zipCode + "'")
                .toString();
    }
}
