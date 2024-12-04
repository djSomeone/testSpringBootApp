package com.first_spring_boot_project.demo.services;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.first_spring_boot_project.demo.model.user;
import com.first_spring_boot_project.demo.repositry.userRepositry;

@Service
public class userServices {

    @Autowired
    private userRepositry userReepo;

    // constructor
    public userServices(userRepositry userRepo){
        this.userReepo=userRepo;
    }

    public List<user> getAllUsers(){
        return this.userReepo.findAll();
    }

    public user saveUser(user userData){
        user savedData =this.userReepo.save(userData);
        return savedData;
    }

    public boolean deleteUserById(Long id){
        try{
            
             this.userReepo.deleteById(id);
             return true;
        }catch(Exception e){
            return false;
        }
        
    }

    public Optional<user> findUser(Long id){
        
        Optional<user> data=this.userReepo.findById(id);
        return data;
    }

    public Optional<user> updateUserData(Long id,user updatedData)
    {
        System.out.println("in servicee method");
        Optional<user> data=this.findUser(id);
        if(data.isPresent()){
            user u=userReepo.save(updatedData);
            return Optional.of(u);
            
        }
        System.err.println(data.isPresent());
        return   Optional.empty();
    }

    
}
