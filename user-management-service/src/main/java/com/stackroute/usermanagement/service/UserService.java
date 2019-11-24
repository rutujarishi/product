package com.stackroute.usermanagement.service;

import com.stackroute.usermanagement.exceptions.NotUpdatedException;
import com.stackroute.usermanagement.exceptions.UserAlreadyExistsException;
import com.stackroute.usermanagement.exceptions.UserNotFoundException;
import com.stackroute.usermanagement.model.User;

import java.math.BigInteger;
import java.util.List;

public interface UserService {

    public User saveUser(User user)throws UserAlreadyExistsException;
    public List<User> getAllUsers() throws UserNotFoundException;
    public User updateUser (User user) throws UserNotFoundException , NotUpdatedException;
    public String deleteUser(BigInteger number) throws UserNotFoundException ;
    public User findOne(BigInteger number) throws UserNotFoundException;
    public User updateStatus(BigInteger number) throws UserNotFoundException,NotUpdatedException;
//    public List<User> findTitleByName(String trackName);
}
