/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package de.jgsoftware.webshop.serivce.interfaces;

import de.jgsoftware.webshop.dao.interfaces.shop.i_dao_products;

/**
 *
 * @author root
 */
public interface i_service_products 
{
    i_dao_products getIdaoproducts();
    void setIdaoproducts(i_dao_products idaoproducts);
    
}
