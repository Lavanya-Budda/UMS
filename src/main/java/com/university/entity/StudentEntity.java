package com.university.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "student")
public class StudentEntity {

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "student_name")
    private String sName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "b_id")
    private Long bId;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "s_id", referencedColumnName = "id")
    private List<SubjectEntity> subjectEntities;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private AddressEntity address;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "u_id", referencedColumnName = "id")
    private List<UserLogin> userLogin;

    public StudentEntity(Long id, String sName, String email, String password, String phoneNumber, Long bId) {
        this.id = id;
        this.sName = sName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.bId = bId;
    }

    public StudentEntity(Long id, String sName, String email, String password, String phoneNumber, AddressEntity address) {
        this.id = id;
        this.sName = sName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public StudentEntity(Long id, String sName, String email, String password, String phoneNumber) {
        this.id = id;
        this.sName = sName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public Long getbId() {
        return bId;
    }

    public void setbId(Long bId) {
        this.bId = bId;
    }

    public List<UserLogin> getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(List<UserLogin> userLogin) {
        this.userLogin = userLogin;
    }

    public StudentEntity() {
    }

    public Long getId() {
        return id;
    }

    public List<SubjectEntity> getSubjectEntities() {
        return subjectEntities;
    }

    public void setSubjectEntities(List<SubjectEntity> subjectEntities) {
        this.subjectEntities = subjectEntities;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }
}
