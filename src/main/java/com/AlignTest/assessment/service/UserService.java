package com.AlignTest.assessment.service;

import com.AlignTest.assessment.model.User;
import com.AlignTest.assessment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    // CREATE 
    public User createUser(User emp) {
        return userRepository.save(emp);
    }

    // READ
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    // DELETE
    public void deleteUser(Long empId) {
        userRepository.deleteById(empId);
    }

    // UPDATE
    public User updateUser(Long empId, User employeeDetails) {
        User emp = userRepository.findById(empId).get();
        emp.setUsername(employeeDetails.getUsername());
        emp.setEmail(employeeDetails.getEmail());
        emp.setPassword(employeeDetails.getPassword());
        emp.setRole(employeeDetails.getRole());

        return userRepository.save(emp);
    }
}
