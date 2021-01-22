package com.spring.controllers;

import com.spring.entities.PrivateUser;
import com.spring.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.spring.repositories.UserRepository;

import java.util.List;

@RestController //уже не Controller
@RequestMapping("/api/users")
@CrossOrigin("*") // важно, почитать
public class UserRESTController {

    @Autowired
    private UserRepository repository;

    @GetMapping() //множественное число по стандарту
    public List<UserEntity> showAllEmployees(){
        List<UserEntity> allUserEntities = repository.findAll();
        return allUserEntities; // на данном моменте Spring включает jackson,
        // который кон  вертит java objects в json
        // и нам больше ничего не нужно делать!
    }


    @GetMapping("/{id}") //вместо Id мы можем поставить что угодно
    public PrivateUser getEmployee(@PathVariable int id) { //получаем занчение из URL
        PrivateUser employee = PrivateUser.getPrivateEmp(repository.findById(id).get());
        return employee;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserEntity addNewEmployees(@RequestBody UserEntity userEntity) {  //Достаём работника из body
        repository.save(userEntity);
        //jpaService.saveEmployeeToDB();
        return userEntity;
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE) //множественное число по стандарту
    public UserEntity updateEmployees(@RequestBody UserEntity userEntity) {  //Достаём работника из body
        repository.save(userEntity);
        return userEntity;
    }

    @DeleteMapping("/{id}") //вместо Id мы можем поставить что угодно
    public String deleteEmployee(@PathVariable int id) { //получаем занчение из URL
       // Employee employee = employeeService.getEmployee(id);

        repository.deleteById(id);
        return "User with ID = " + id + " was deleted!";
    }
}
