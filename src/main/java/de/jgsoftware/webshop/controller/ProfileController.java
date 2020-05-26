package de.jgsoftware.webshop.controller;


import java.security.Principal;
import java.util.List;

import de.jgsoftware.webshop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import de.jgsoftware.webshop.model.User;

import de.jgsoftware.webshop.dao.DaoProduct;

import de.jgsoftware.webshop.service.User_Service;


@Controller
@RequestMapping("profile")
public class ProfileController
{


    @Autowired
    User_Service user_service;

    @Autowired
    DaoProduct dproduct;



    @GetMapping("addToCart/{productId}")
    public ModelAndView addToCart(@PathVariable("productId")String productId,Principal principal)
    {

        ModelAndView mv = new ModelAndView("profile/cart-product");
        //User user = userService.findByEmail(principal.getName());

        List<User> user = user_service.getDaoUser().findByEmail(principal.getName());

        long productLongId = Long.parseLong(productId);
        Product product = dproduct.getProductById(productLongId);


       // Product product = productService.getProductById(productLongId).get();

        //List<Product> productList = new ArrayList<Product>();
        //productList.add(product);


        //de.jgsoftware.webshop.model.User_Product_List user_product_list = new de.jgsoftware.webshop.model.User_Product_List();
        //user_product_list.getUser_id();
        //user_product_list.getProduct_id();

        //user_product_list_service.getDaoUser_product_list().save(user_product_list);


        /*
        productService.addProduct(product);
        //userService.update(user);
        double total = findSum(user);


        mv.addObject("total", total);
        mv.addObject("user", user);
        */

        return mv;
    }


}