package de.jgsoftware.webshop.controller;


import java.security.Principal;
import java.util.*;

import de.jgsoftware.webshop.model.Kundenstamm;
import de.jgsoftware.webshop.model.Users;
import de.jgsoftware.webshop.service.Index_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedCaseInsensitiveMap;
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
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("profile")
public class ProfileController
{



    @Autowired
    User_Service user_service;

    @Autowired
    DaoProduct dproduct;

    List<Kundenstamm> kdstamm;

    Double shoppingpriceitem = Double.valueOf(1.00);
    Double ustproductchart = null;


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

        /*
                get customer data from table kundenstamm
                over email from loginsession
         */
        String stemail = principal.getName();
        List<Kundenstamm> kdstamm = user_product_list_service.getDoaUserProductList().getCustomerdataoveremail(stemail);
        /*
                userdata from table Kundenstamm over
                email address query
         */
        prodtlists.put("customerdata", kdstamm);

        //prodtlists.put("userproduct", );

        /*
                retuns over id
                query
                kundenstamm all
                -> User_productlist all / -> get Products from user // customer chart
                -> Product_check_out_text all / -> get Products text over id for display in
                                                   customer chart on html

         */
        Integer kundennummer_id = (Integer) kdstamm.get(0).getId();
        prodtlists.put("kstammdata", user_product_list_service.getDoaUserProductList().getCheckoutdata(kundennummer_id));


        List productswithtextandprice = (ArrayList) user_product_list_service.getDoaUserProductList().getCustomercheckoutproductswithprice(kundennummer_id);
        prodtlists.put("productswithtext", productswithtextandprice);



        /*

                add price to
                shopping chart items


         */

        double shoppingpriceitem = 0;
        if(shoppingpriceitem == 0.00)
        {
            System.out.print("shpping item is 0");
            shoppingpriceitem = Double.valueOf(1.00);
        }
        // shopping price total
        double dobletotal = user_product_list_service.priceshoppingchart(shoppingpriceitem, productswithtextandprice);
        prodtlists.put("shoppingchartpricetotal", dobletotal);


        // ustproductchart
        double ustchart = user_product_list_service.getUSTChart(dobletotal);
        prodtlists.put("ustproductchart", ustchart);
        prodtlists.put("itemchart", shoppingpriceitem);

        return new ModelAndView("/profile/cart-product.html", prodtlists);
    }

    @PostMapping("updatechart")
    public ModelAndView updatechart(@RequestParam(value = "updatechart", required = false) String updatechart, Integer id, Integer shoppingpriceitem, Principal principal) {


        if(shoppingpriceitem == 0)
        {
            System.out.print("shpping item is 0");
            shoppingpriceitem = 1;
        }
        else if (shoppingpriceitem > 0)
        {
            System.out.println("Number is positive");
        }
        else
        {
            System.out.println("Number is negative");
            shoppingpriceitem = 1;  // set to 1
        }

        Map<String, Object> prodtlists = new HashMap<>();

        /*
                get customer data from table kundenstamm
                over email from loginsession
         */
        String stemail = principal.getName();
        List<Kundenstamm> kdstamm = user_product_list_service.getDoaUserProductList().getCustomerdataoveremail(stemail);
        /*
                userdata from table Kundenstamm over
                email address query
         */
        prodtlists.put("customerdata", kdstamm);

        //prodtlists.put("userproduct", );

        /*
                retuns over id
                query
                kundenstamm all
                -> User_productlist all / -> get Products from user // customer chart
                -> Product_check_out_text all / -> get Products text over id for display in
                                                   customer chart on html

         */
        Integer kundennummer_id = (Integer) kdstamm.get(0).getId();
        prodtlists.put("kstammdata", user_product_list_service.getDoaUserProductList().getCheckoutdata(kundennummer_id));


        List productswithtextandprice = (ArrayList) user_product_list_service.getDoaUserProductList().getCustomercheckoutproductswithprice(kundennummer_id);

        prodtlists.put("productswithtext", productswithtextandprice);



        /*

                add price to
                shopping chart items


         */
       // shoppingpriceitem = shoppingpriceitem;

        // shopping price total
        double dobletotal = user_product_list_service.priceshoppingchart(Double.valueOf(shoppingpriceitem), productswithtextandprice);
        prodtlists.put("shoppingchartpricetotal", dobletotal);


        // ustproductchart
        double ustchart = user_product_list_service.getUSTChart(dobletotal);
        prodtlists.put("ustproductchart", ustchart);
        prodtlists.put("itemchart", shoppingpriceitem);

        return new ModelAndView("/profile/cart-product.html", prodtlists);

    }




}