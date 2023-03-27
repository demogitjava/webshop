/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.jgsoftware.webshop.serivce;

import de.jgsoftware.webshop.dao.interfaces.shop.i_dao_products;
import de.jgsoftware.webshop.serivce.interfaces.i_service_products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author root
 */
@Service
public class Service_Products implements i_service_products
{
    
    @Autowired
    i_dao_products idaoproducts;

    @Override
    public i_dao_products getIdaoproducts() {
        return idaoproducts;
    }

    /**
     *
     * @param idaoproducts
     */
    @Override
    public void setIdaoproducts(i_dao_products idaoproducts) {
        this.idaoproducts = idaoproducts;
    }
    
    
    
}
