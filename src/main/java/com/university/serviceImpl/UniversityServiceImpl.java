package com.university.serviceImpl;

import com.university.confing.StudentRepo;
import com.university.dao.UniversityDao;
import com.university.entity.BranchEntity;
import com.university.entity.StudentEntity;
import com.university.entity.UniversityEntity;
import com.university.entity.UserLogin;
import com.university.jwt.JwtToken;
import com.university.request.LoginRequest;
import com.university.responce.StudentDetails;
import com.university.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UniversityServiceImpl implements UniversityService {

    @Autowired
    private UniversityDao universityDao;
    @Autowired
    private JwtToken jwtToken;

    @Autowired
    private StudentRepo studentRepo;

    LoginRequest loginRequest;

    @Override
    public UniversityEntity saveUniversity(UniversityEntity universityEntity) {
        return universityDao.addUniversity(universityEntity);
    }

    @Override
    public boolean loginStatus(LoginRequest loginRequest) {
        this.loginRequest = loginRequest;
        StudentEntity studentEntity = universityDao.findByEmail(loginRequest.getEmail());
        if (studentEntity != null && loginRequest.getPassword().equals(studentEntity.getPassword())) {
            UserLogin userLogin = new UserLogin();
            userLogin.setsId(studentEntity.getId());
            userLogin.setLoginDateAndTime(new Date(System.currentTimeMillis()));
            userLogin.setToken(jwtToken.generateToken(studentEntity.getEmail()));
            universityDao.loginStatus(userLogin);
            return true;
        }
        return false;
    }

    public StudentDetails studentDetails() {
        StudentDetails studentDetails;
        StudentEntity studentEntity = universityDao.findByEmail(loginRequest.getEmail());
        if (studentEntity != null && loginRequest.getPassword().equals(studentEntity.getPassword())) {
            BranchEntity branchEntity = universityDao.findByStudentBid(studentEntity.getbId());
            UniversityEntity universityEntity = universityDao.findByEmailAndId(branchEntity.getuId());
            //StudentDetails studentDetails=new StudentDetails(studentEntity.getId(), studentEntity.getsName(), studentEntity.getEmail(), studentEntity.getPhoneNumber(), universityEntity.getUniversityName(), branchEntity.getBranchName());
            studentDetails = new StudentDetails();
            studentDetails.setStudId(studentEntity.getId());
            studentDetails.setsName(studentEntity.getsName());
            studentDetails.setEmail(studentEntity.getEmail());
            studentDetails.setPhoneNumber(studentEntity.getPhoneNumber());
            studentDetails.setBranch(branchEntity.getBranchName());
            studentDetails.setUniversity(universityEntity.getUniversityName());

        return studentDetails;
        }else {
            studentDetails=new StudentDetails();
            studentDetails.setsName("Object Not found!!!");
            return studentDetails;
        }


    }
}
