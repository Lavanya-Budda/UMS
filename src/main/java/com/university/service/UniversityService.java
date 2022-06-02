package com.university.service;

import com.university.entity.UniversityEntity;
import com.university.request.LoginRequest;
import com.university.responce.StudentDetails;

public interface UniversityService {
    public UniversityEntity saveUniversity(UniversityEntity universityEntity);
    public boolean loginStatus(LoginRequest loginRequest);
    public StudentDetails studentDetails();
}
