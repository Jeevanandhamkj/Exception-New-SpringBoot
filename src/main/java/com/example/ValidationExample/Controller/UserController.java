package com.example.ValidationExample.Controller;

import com.example.ValidationExample.Advice.UserAlreadyExistsException;
import com.example.ValidationExample.Advice.UserNotFoundException;
import com.example.ValidationExample.Entity.User;
import com.example.ValidationExample.Service.UserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    Logger logger= LoggerFactory.getLogger(UserController.class);
    @Autowired

    UserService userService;
    @PostMapping("/add")
    public User adding(@RequestBody @Valid User user) throws UserAlreadyExistsException {
    User u=userService.getUserByEmail(user.getEmail());
    if(u!=null){
        throw new UserAlreadyExistsException("user with "+user.getEmail()+"Already exists");
    }
    else{
        logger.debug("User has been Added");
        return userService.adding(user);
    }
    }

    @GetMapping("/view/{id}")
    public User viewByID(@PathVariable int id) throws UserNotFoundException {
        User user = userService.getUserbyid(id);
        if(user != null) {
            logger.debug("User retrieved by id: " + id);
            return userService.getUserbyid(id);
        } else {
            throw new UserNotFoundException("User with id " + id + " not found");
        }
    }

    @GetMapping("/viewAll")
    public List<User> ViewAll(){
        logger.warn("All users are retreving");
        return userService.getAll();
    }
}
