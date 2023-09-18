/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package de.jgsoftware.webshop.dao.interfaces.shop;

import org.springframework.data.jpa.repository.JpaRepository;
import de.jgsoftware.webshop.model.jpa.shopdb.Products;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


/**
 *
 * @author hoscho
 */
@Repository
public interface i_jpa_products extends JpaRepository<Products, Integer>
{
    
    /*
    
        database shopdb
        table products  column landingpage 
        for 1 the product was displayed on the landingpage
    */
    @Query(value="select form products where landingpage = 1", nativeQuery = true)
    List<Products> allactiveprodcuts();
    
    @Query(value="select * from prodcuts where p.product_id = :product_id", nativeQuery = true)
    List<Products> getselectedproduct();
}
