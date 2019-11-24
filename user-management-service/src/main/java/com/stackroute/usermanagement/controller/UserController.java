package com.stackroute.usermanagement.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.usermanagement.exceptions.NotUpdatedException;
import com.stackroute.usermanagement.exceptions.UserAlreadyExistsException;
import com.stackroute.usermanagement.exceptions.UserNotFoundException;
import com.stackroute.usermanagement.model.User;
import com.stackroute.usermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;

    }

    private BigInteger num = BigInteger.ONE;
    @PostMapping(value = "/saveUserProfile")
    public ResponseEntity saveUserProfile (@RequestParam("file") MultipartFile file, @RequestParam("files") MultipartFile files,@RequestParam("user") String user) throws IOException, UserAlreadyExistsException {
        User user1 = new ObjectMapper().readValue(user, User.class);
//    user1.setFile(file);
        byte[] logo = file.getBytes();
        byte[] logos = files.getBytes();

        String s = Base64.getEncoder().encodeToString(logo);
        String s1 = Base64.getEncoder().encodeToString(logos);
//        user1.setExtension(files.get)
        user1.setImage(s);
        user1.setImage1(s1);
        user1.setFileDl(file.getOriginalFilename());
        user1.setFileDlb(files.getOriginalFilename());
        user1.setSubmittedOn(new Date());
        user1.setIsBlocked("Blocked");
        num = num.add(BigInteger.ONE);
        user1.setNumber(num);
        User dbuser = userService.saveUser(user1);
        System.out.println(dbuser.getDob());
        System.out.println(dbuser);
        try {
            System.out.println(dbuser);
            return new ResponseEntity<>(dbuser, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

//    @GetMapping("/getUser/{number}")
//    public ResponseEntity<User> getUser(@PathVariable BigInteger number) throws UserNotFoundException  {
//        if (number == null) {
//            throw new NullPointerException(("Null"));
//        }
//        User user = userService.findOne(number);
//        return new ResponseEntity(user, HttpStatus.OK);
//    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers() throws UserNotFoundException {
        List<User> user = userService.getAllUsers();
        return new ResponseEntity<List<User>>(user, HttpStatus.OK);
    }

//    @DeleteMapping("/delete/{number}")
//    public ResponseEntity deleteUser(@PathVariable BigInteger number) throws UserNotFoundException {
//        ResponseEntity responseEntity;
//
//        User user = new User();
//        user.setUpdatedAt(new Date());
//        user.setNumber(number);
//        responseEntity = new ResponseEntity<>(userService.deleteUser(number), HttpStatus.OK);
//        return responseEntity;
//    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody User user) throws UserNotFoundException , NotUpdatedException {
        user.setUpdatedAt(new Date());
        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
    }
    @PutMapping("/update/status")
    public ResponseEntity updateStatus(@RequestParam String numberAsString) throws UserNotFoundException,NotUpdatedException {
//           User user  = userService.updateStatus(BigInteger.valueOf(Long.parseLong(numberAsString)));
        return new ResponseEntity<>(userService.updateStatus(BigInteger.valueOf(Long.parseLong(numberAsString))), HttpStatus.OK);
    }

}
