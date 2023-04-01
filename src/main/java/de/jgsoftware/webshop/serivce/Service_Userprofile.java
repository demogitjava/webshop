package de.jgsoftware.webshop.serivce;


import de.jgsoftware.webshop.dao.Dao_userprofile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.jgsoftware.webshop.serivce.interfaces.i_service_userprofile;

/**
 *
 * @author hoscho
 */

@Service
public class Service_Userprofile implements i_service_userprofile
{


    @Autowired
    Dao_userprofile dao_userprofile;

    public Dao_userprofile getDao_userprofile() {
        return dao_userprofile;
    }

    public void setDao_userprofile(Dao_userprofile dao_userprofile) {
        this.dao_userprofile = dao_userprofile;
    }
}
