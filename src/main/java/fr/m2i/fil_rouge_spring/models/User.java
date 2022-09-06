package fr.m2i.fil_rouge_spring.models;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long _id;

    @Basic
    @Column(name = "first_name")
    private String first_name;

    @Basic
    @Column(name = "last_name")
    private String last_name;

    @Basic
    @Column(name = "city")
    private String city;

    @Basic
    @Column(name = "street")
    private String street;

    @Basic
    @Column(name = "zipcode")
    private String zipcode;

    @Basic
    @Column(name = "country")
    private String country;

    @Basic
    @Column(name = "role")
    private String role;

    @Basic
    @Column(name = "email")
    private String email;

    @Basic
    @Column(name = "password")
    private String password;

    @Basic
    @Column(name = "is_connected")
    private Boolean is_connected;

    public User() {

    }

    public User(String first_name, String last_name, String city, String street, String zipcode, String country,
                String role, String email, String password, Boolean is_connected) {
        super();
        this.first_name = first_name;
        this.last_name = last_name;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
        this.country = country;
        this.role = role;
        this.email = email;
        this.password = password;
        this.is_connected = is_connected;
    }

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIsConnected() {
        return is_connected;
    }

    public void setIsConnected(Boolean is_connected) {
        this.is_connected = is_connected;
    }
}
