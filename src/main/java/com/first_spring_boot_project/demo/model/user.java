package com.first_spring_boot_project.demo.model;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;


    @Column
    public String name;

    @Column
    public boolean isAdmin ;

    public user(String name,boolean isAdmin,String imgPath){
        this.name=name;
        this.isAdmin=isAdmin;
        this.imgPath=imgPath;
    }

    @Column
    @Nullable
    public String imgPath;

    public user(){}

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public Long getId() {
        return id;
    }
    

}
