package com.university.controller;

import com.university.entity.UniversityEntity;
import com.university.request.LoginRequest;
import com.university.responce.LoginResponce;
import com.university.responce.StudentDetails;
import com.university.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UniversityController {

    @Autowired
    private UniversityService universityService;

    @PostMapping("/add")
    public UniversityEntity university(@RequestBody UniversityEntity universityEntity) {
        return universityService.saveUniversity(universityEntity);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponce> login(@RequestBody LoginRequest loginRequest) {

        LoginResponce loginResponce = new LoginResponce();
        if (universityService.loginStatus(loginRequest)) {
            loginResponce.setMessage("Login Success");
        } else {
            loginResponce.setMessage("Login Failed");
        }
        return new ResponseEntity<>(loginResponce, HttpStatus.OK);
    }

    @PostMapping("/login1")
    public ResponseEntity<StudentDetails> loginStudent(@RequestBody LoginRequest loginRequest) {

        StudentDetails studentDetails = null;
        try {

            if (universityService.loginStatus(loginRequest)) {

                studentDetails = universityService.studentDetails();
                return new ResponseEntity<StudentDetails>(studentDetails, HttpStatus.OK);
            } else {
                studentDetails = new StudentDetails();
                studentDetails.setsName("Object Not Found!!!");
                LoginResponce responce = new LoginResponce();
                responce.setMessage("object Not found");
                return new ResponseEntity<StudentDetails>(studentDetails, HttpStatus.OK);
            }


        } catch (Exception e) {
            return new ResponseEntity<StudentDetails>(studentDetails, HttpStatus.OK);
        }
    }

}
