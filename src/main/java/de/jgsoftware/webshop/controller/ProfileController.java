package de.jgsoftware.webshop.controller;


import java.security.Principal;
import java.util.List;

import de.jgsoftware.webshop.model.Product;
import de.jgsoftware.webshop.service.Index_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import de.jgsoftware.webshop.model.User;
import de.jgsoftware.webshop.dao.DaoProduct;

import de.jgsoftware.webshop.service.User_Service;
import de.jgsoftware.webshop.service.Product_Service;
//import de.jgsoftware.webshop.service.User_Product_List_Service;

import de.jgsoftware.webshop.service.interfaces.User_Product_List_Interface;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@Controller
@RequestMapping("profile")
public class ProfileController
{


    @Autowired
    User_Service user_service;

    @Autowired
    DaoProduct dproduct;


    @Autowired
    Product_Service product_service;

    @Autowired
    User_Product_List_Interface user_product_list_service;

    private  ViewControllerRegistry registry;


    @Autowired
    Index_Service indexservice;

    @Autowired
    User_Service userService;



    @GetMapping("addToCart/{productId}")
    public String addToCart(@PathVariable("productId") String productId, Principal principal, Model model)
    {


        //User user = userService.findByEmail(principal.getName());

        List<User> user = user_service.getDaoUser().findByEmail(principal.getName());
        user.get(0).getUserId();

        long productLongId = Long.parseLong(productId);
        Product product = dproduct.getProductById(productLongId);


        de.jgsoftware.webshop.model.USER_PRODUCT_LIST user_product_list = new de.jgsoftware.webshop.model.USER_PRODUCT_LIST();

        user_product_list.setProduct_id(productLongId);


        Integer userid = user.get(0).getUserId();
        user_product_list.setUser_id(userid);
        user_product_list.setProduct_id(productLongId);


        user_product_list_service.getDoaUserProductList().saveEntrytoDatabase(user_product_list);



        //return indexcontroller.index(model);
        return "redirect:/";
    }

}