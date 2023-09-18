/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package de.jgsoftware.webshop.dao.interfaces.shop;

import org.springframework.data.jpa.repository.JpaRepository;
import de.jgsoftware.webshop.model.jpa.shopdb.Products;
import org.springframework.stereotype.Repository;
/**
 *
 * @author hoscho
 */
@Repository
public interface i_jpa_products extends JpaRepository<Products, Integer>
{
    
}
