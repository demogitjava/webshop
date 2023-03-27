package de.jgsoftware.webshop.controller;


import de.jgsoftware.webshop.controller.interfaces.i_shoppingcart;
import de.jgsoftware.webshop.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import de.jgsoftware.webshop.model.shoppingcart;

import de.jgsoftware.webshop.serivce.interfaces.i_shoppingcart_service;

@Controller
public class ShoppingcartController implements i_shoppingcart
{


    Principal principal;


    @Autowired
    i_shoppingcart_service shoppingcart_service;


    @Override
    public String addToCart(@PathVariable("productId") String productId, Principal principal, Model model)
    {


        String stusername = principal.getName();



        /*
            return enabled user from
            demodb table users


         */
        List<Users> lsusers = (List<Users>) shoppingcart_service.getShcart().getloggedinuserdata(stusername);

        /*

                    private int id;
                    private int user_id;
                    private long product_id;
         */
        shoppingcart mshopingcart = new shoppingcart();

        // get id from table users
        long idusers = lsusers.get(0).getId();
        mshopingcart.setUser_id((int) idusers);
        mshopingcart.setProduct_id(Long.parseLong(productId));



        List<shoppingcart> shlist = new ArrayList<shoppingcart>();
        shlist.add(mshopingcart);


        shoppingcart_service.getShcart().saveprodcut(shlist);

        return "redirect:/";
    }

}
