package de.jgsoftware.webshop.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.jgsoftware.webshop.dao.DaoProduct;


@Service
public class Product_Service
{

    @Autowired
    DaoProduct daoProduct;


    public DaoProduct getDaoProduct() {
        return daoProduct;
    }

    public void setDaoProduct(DaoProduct daoProduct) {
        this.daoProduct = daoProduct;
    }
}
