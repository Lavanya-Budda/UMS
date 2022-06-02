package com.university.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subject_entity")
public class SubjectEntity {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "subject_name")
    private String subName;
    @Column(name = "marks")
    private Long marks;

    public SubjectEntity(Long id, String subName, Long marks) {
        this.id = id;
        this.subName = subName;
        this.marks = marks;
    }

    public SubjectEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public Long getMarks() {
        return marks;
    }

    public void setMarks(Long marks) {
        this.marks = marks;
    }

}
