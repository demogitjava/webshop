package de.jgsoftware.webshop.controller.interfaces;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;


/**
 *
 * @author hoscho
 */
@RequestMapping("shoppingcart")
@PreAuthorize("hasAuthority('ROLE_ADMIN','ROLE_USER')")
public interface i_shoppingcart
{

    @GetMapping("addToCart/{productId}")
    String addToCart(@PathVariable("productId") String productId, Principal principal, Model model);
}
