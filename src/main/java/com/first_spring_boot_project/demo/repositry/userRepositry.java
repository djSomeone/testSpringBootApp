package com.first_spring_boot_project.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.first_spring_boot_project.demo.model.user;

public interface userRepositry extends JpaRepository<user,Long> {   
}
