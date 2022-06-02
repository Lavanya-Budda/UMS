package com.university.entity;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class AddressEntity {

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "state")
    private String state;
    @Column(name = "district")
    private String district;
    @Column(name = "city")
    private String city;
    @Column(name = "pincode")
    private String pincode;

    public AddressEntity(Long id, String state, String district, String city, String pincode) {
        this.id = id;
        this.state = state;
        this.district = district;
        this.city = city;
        this.pincode = pincode;
    }

    public AddressEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}
