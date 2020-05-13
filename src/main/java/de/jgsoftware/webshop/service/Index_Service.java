package de.jgsoftware.webshop.service;

import de.jgsoftware.webshop.dao.DaoIndex;
import de.jgsoftware.webshop.dao.DaoProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Index_Service
{

    @Autowired
    DaoIndex daoindex;


    @Autowired
    DaoProduct daoProduct;

    public DaoProduct getDaoProduct() {
        return daoProduct;
    }

    public void setDaoProduct(DaoProduct daoProduct) {
        this.daoProduct = daoProduct;
    }

    public DaoIndex getDaoindex() {
        return daoindex;
    }

    public void setDaoindex(DaoIndex daoindex) {
        this.daoindex = daoindex;
    }

    public DaoIndex getDaoIndex()
    {


        return daoindex;
    }
}
