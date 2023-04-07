package de.jgsoftware.webshop.serivce;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import de.jgsoftware.webshop.serivce.interfaces.i_service_admin;
import de.jgsoftware.webshop.dao.interfaces.shop.i_dao_admin;


import com.ebay.api.client.auth.oauth2.CredentialUtil;
import com.ebay.api.client.auth.oauth2.OAuth2Api;
import com.ebay.api.client.auth.oauth2.model.AccessToken;
import com.ebay.api.client.auth.oauth2.model.OAuthResponse;
import com.ebay.api.client.auth.oauth2.model.Environment;
import com.ebay.api.client.auth.oauth2.model.RefreshToken;
import com.ebay.api.client.auth.oauth2.model.TokenResponse;
import com.ebay.api.client.auth.oauth2.model.TokenType;

/**
 *
 * @author hoscho
 */

@Service
public class Service_Admin implements i_service_admin
{
    @Autowired
    i_dao_admin iDaoAdmin;


    OAuth2Api ebayoauth;
    CredentialUtil ebaycredentialutil;
    AccessToken ebayaccesstoken;
    com.ebay.api.client.auth.oauth2.model.Environment ebayenvironment;

    com.ebay.api.client.auth.oauth2.model.Environment environment;

    @Override
    public i_dao_admin getiDaoAdmin() {
        return iDaoAdmin;
    }


    @Override
    public void setiDaoAdmin(i_dao_admin iDaoAdmin) {
        this.iDaoAdmin = iDaoAdmin;
    }




}
