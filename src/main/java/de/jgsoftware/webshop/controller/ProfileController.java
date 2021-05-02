package de.jgsoftware.webshop.controller;


import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.jgsoftware.webshop.model.Kundenstamm;
import de.jgsoftware.webshop.model.Users;
import de.jgsoftware.webshop.service.Index_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import de.jgsoftware.webshop.dao.DaoProduct;

import de.jgsoftware.webshop.service.User_Service;
import de.jgsoftware.webshop.service.Product_Service;
//import de.jgsoftware.webshop.service.User_Product_List_Service;

import de.jgsoftware.webshop.service.interfaces.User_Product_List_Interface;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.security.core.Authentication;
import java.security.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.security.core.userdetails.UserDetailsService;


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


        String stusername = principal.getName();
        List userlistid = user_product_list_service.getDoaUserProductList().getUserId(stusername);

        Users usermodel = new Users();
        usermodel = (Users) userlistid.get(0);

        Long userid = usermodel.getId();

        user_product_list_service.getDoaUserProductList().saveuserdata(productId, userid);

        //return indexcontroller.index(model);
        return "redirect:/";
    }



    @GetMapping({"cart-product", "/"})
    public ModelAndView index(Principal principal)
    {
        Map<String, Object> prodtlists = new HashMap<>();


        String stemail = principal.getName();

        /*
                userdata from table Kundenstamm over
                email address query
         */
        prodtlists.put("customerdata", user_product_list_service.getDoaUserProductList().getCustomerdataoveremail(stemail));
        //prodtlists.put("userproduct", );



        //prodtlists.put("lang", java.util.Locale.getDefault().getCountry());
        return new ModelAndView("/profile/cart-product.html", prodtlists);
    }

}