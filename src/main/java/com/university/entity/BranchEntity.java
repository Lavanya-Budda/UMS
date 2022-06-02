package com.university.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "branch")
public class BranchEntity {

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "branch_name")
    private String branchName;
    @Column(name = "u_id")
    private Long uId;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "b_id",referencedColumnName = "id")
    private List<StudentEntity> studentEntities;

    public BranchEntity(Long id, String branchName, List<StudentEntity> studentEntities) {
        this.id = id;
        this.branchName = branchName;
        this.studentEntities = studentEntities;
    }

    public BranchEntity(Long id, String branchName, Long uId) {
        this.id = id;
        this.branchName = branchName;
        this.uId = uId;
    }

    public BranchEntity(String branchName, Long uId) {
        this.branchName = branchName;
        this.uId = uId;
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public BranchEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public List<StudentEntity> getStudentEntities() {
        return studentEntities;
    }

    public void setStudentEntities(List<StudentEntity> studentEntities) {
        this.studentEntities = studentEntities;
    }
}
