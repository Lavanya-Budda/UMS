package com.university.dao;

import com.university.entity.BranchEntity;
import com.university.entity.StudentEntity;
import com.university.entity.UniversityEntity;
import com.university.entity.UserLogin;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public interface UniversityDao {
    public SessionFactory sessionFactory();
    public UniversityEntity addUniversity(UniversityEntity universityEntity);

    StudentEntity findByEmail(String email);
    public void loginStatus(UserLogin userLogin);

    BranchEntity findByStudentBid(Long bId);

    UniversityEntity findByEmailAndId(Long uId);
//    public StudentEntity getByEmail(String email);

}
