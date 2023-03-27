/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package de.jgsoftware.webshop.dao.interfaces.shop;

import de.jgsoftware.webshop.model.Product;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 *
 * @author root
 */
public interface i_dao_products 
{
    /*
        load all products with selectected 1 
        in database
    */
    List<Product> getProductsforLandingpage();
    
    /*
        select product by id
    */
    Product getProductById(long productId);
    
    /*
        search product over Textfield 
        in the webshop
    */
    List<Product> searchProductovertextfield(String searchProduct, Pageable pageable);
    
    
    /*
        search product for 
        pages display in webshop
    */
    List<Product> searchProductop25(String searchProduct);
}
