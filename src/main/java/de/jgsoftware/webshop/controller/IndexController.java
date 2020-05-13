package de.jgsoftware.webshop.controller;


import de.jgsoftware.webshop.model.User;
import de.jgsoftware.webshop.service.Index_Service;
import de.jgsoftware.webshop.service.User_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController
{


    @Autowired
    Index_Service indexservice;

    @Autowired
    User_Service userService;



    // load default landingpage
    @GetMapping({"index", "/"})
    public String index(Model model)
    {


        model.addAttribute("productList", indexservice.getDaoProduct().getProductsforLandingpage());


        return "index";
    }

    @GetMapping("login")
    public String login()
    {
        return "login";
    }

    @GetMapping("signup")
    public String singup()
    {
        return "singup";
    }

    @PostMapping("signup")
    public User signUp(User user)
    {
        
        
        return user;
    }


}
