package com.university.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "university")
public class UniversityEntity {

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "university_name")
    private String universityName;
    @Column(name = "university_address")
    private String univercityAddress;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "u_id",referencedColumnName = "id")
    private List<BranchEntity> branchEntities;

    public UniversityEntity(Long id, String universityName, String univercityAddress, List<BranchEntity> branchEntities) {
        this.id = id;
        this.universityName = universityName;
        this.univercityAddress = univercityAddress;
        this.branchEntities = branchEntities;
    }

    public UniversityEntity(Long id, String universityName, String univercityAddress) {
        this.id = id;
        this.universityName = universityName;
        this.univercityAddress = univercityAddress;
    }

    public UniversityEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getUnivercityAddress() {
        return univercityAddress;
    }

    public void setUnivercityAddress(String univercityAddress) {
        this.univercityAddress = univercityAddress;
    }

    public List<BranchEntity> getBranchEntities() {
        return branchEntities;
    }

    public void setBranchEntities(List<BranchEntity> branchEntities) {
        this.branchEntities = branchEntities;
    }
}
