package de.jgsoftware.webshop.controller;

import de.jgsoftware.webshop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/login")
public class LoginController
{

    @Autowired
    de.jgsoftware.webshop.service.User_Service user_service;

    @PostMapping("/")
    public List<User> getUserListbyEmail(String email, User user)
    {

        user_service.getDaoUser().findByEmail(email);


        return getUserListbyEmail(email, user);
    }
}
