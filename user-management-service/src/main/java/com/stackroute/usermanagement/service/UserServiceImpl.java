package com.stackroute.usermanagement.service;

import com.stackroute.usermanagement.exceptions.NotUpdatedException;
import com.stackroute.usermanagement.exceptions.UserAlreadyExistsException;
import com.stackroute.usermanagement.exceptions.UserNotFoundException;
import com.stackroute.usermanagement.model.User;
import com.stackroute.usermanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user)throws UserAlreadyExistsException

    {
        user = userRepository.save(user);
        return user;
    }

    @Override
    public List<User> getAllUsers()  throws UserNotFoundException {
        return userRepository.findAll();

    }

    @Override
    public User updateUser(User user) throws UserNotFoundException, NotUpdatedException {
        User user1 = userRepository.findById(user.getNumber()).get();

        return user1;
    }
    @Override
    public User updateStatus(BigInteger number) throws UserNotFoundException, NotUpdatedException {
        User user1 = userRepository.findById(number).get();
        user1.setUpdatedAt(new Date());
         user1.setIsBlocked("Unblocked");
         userRepository.save(user1);
        return user1;
    }

    @Override
    public String deleteUser(BigInteger number) {
        userRepository.deleteById(number);
        return "User is deleted";
    }

    @Override
    public User findOne(BigInteger number) {
        return userRepository.findById(number).orElse(new User());
    }



//    @Override
//    public List<User> findTitleByName(String trackName) {
//        return null;
//    }
}
