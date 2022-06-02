package com.university.confing;

import com.university.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<StudentEntity , Long> {
    public StudentEntity findByEmail(String email);
}
