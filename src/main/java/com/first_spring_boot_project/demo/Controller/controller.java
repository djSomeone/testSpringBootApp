package com.first_spring_boot_project.demo.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.first_spring_boot_project.demo.model.user;
import com.first_spring_boot_project.demo.services.userServices;

import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.StackWalker.Option;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;






// @Controller
@RestController
@RequestMapping("/user")
public class controller {

    private userServices usrSer;
    
    public controller(userServices u){
        this.usrSer=u;
    }
     @PostMapping("/register")
     public ResponseEntity<user> registerUser(@Validated @RequestBody user data) {
         user savedData=usrSer.saveUser(data);
         return new ResponseEntity<user>(savedData, HttpStatusCode.valueOf(200));
     }

     @GetMapping("/list")
     public ResponseEntity<List<user>> userList() {
        List<user> userList=usrSer.getAllUsers();
        System.out.println(userList.toString());
         return new ResponseEntity<List<user>>(userList,HttpStatusCode.valueOf(200));
     }

     @DeleteMapping("/delete")
     public ResponseEntity<Map> deleteUser(@RequestParam Long id) {
        Optional<user> data=usrSer.findUser(id);
        System.out.println(data.isPresent());
        if(data.isPresent()){
            usrSer.deleteUserById(id);
            }
            String message=data.isPresent()?"user deleted successfully":"User is not prasent.";
         Map<String,Object> response=Map.of("message",message);
        return new ResponseEntity<Map>(response,HttpStatusCode.valueOf(200));
     }

     @PostMapping("/update")
     public ResponseEntity<Map> updateUserDetail(@RequestBody user entity) {
         //TODO: process POST request
         Optional<user> res=usrSer.updateUserData(entity.id, entity);
         
         String message=res.isPresent()?"user updated successfully":"User is not prasent.";
         Map<String,Object> response=Map.of("message",message,"data",(res.isPresent())?(res.get()):(new HashMap<>()));
         return new ResponseEntity<Map>(response,HttpStatusCode.valueOf(200));
     }
     
     
     
    
   
    
}
