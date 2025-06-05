package com.CRUD.Service;

import com.CRUD.Exception.DuplicateUserException;
import com.CRUD.Model.User;
import com.CRUD.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User addUser(User user){
        if(userRepository.existsByName(user.getName())){
            throw new DuplicateUserException("User already present");
        }
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Integer id){
        return userRepository.findById(id);
    }

    public User updateUser(Integer id,User user){
        return userRepository.findById(id).map(user1->{
            user1.setName(user.getName());
            user1.setCity(user.getCity());
            return userRepository.save(user1);
        }).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"User Not Found"));
    }

    public String deleteUser(Integer id){
        userRepository.deleteById(id);
        return "User is Deleted";
    }
}
