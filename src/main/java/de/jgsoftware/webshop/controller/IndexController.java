package de.jgsoftware.webshop.controller;


import de.jgsoftware.webshop.service.Index_Service;
import de.jgsoftware.webshop.service.User_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

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
    public ModelAndView index()
    {


        Map<String, Object> prodtlists = new HashMap<>();
        prodtlists.put("productList", indexservice.getDaoProduct().getProductsforLandingpage());

        return new ModelAndView("index", prodtlists);
    }


    @GetMapping("login")
    public String login() {
        return "login";
    }


    @PostMapping("addProcducttocase")
    public ModelAndView getProduct()
    {
        ModelAndView mv = new ModelAndView("index");


        return mv;
    }



}
