package de.jgsoftware.webshop.service;


import de.jgsoftware.webshop.dao.Doa_UserProductList;
import de.jgsoftware.webshop.service.interfaces.User_Product_List_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class User_Product_List_Service implements User_Product_List_Interface
{

    @Autowired
    de.jgsoftware.webshop.dao.Doa_UserProductList doaUserProductList;

    public Doa_UserProductList getDoaUserProductList() {
        return doaUserProductList;
    }

    public void setDoaUserProductList(Doa_UserProductList doaUserProductList) {
        this.doaUserProductList = doaUserProductList;
    }
}
