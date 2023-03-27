package de.jgsoftware.webshop.dao.interfaces.shop;

import de.jgsoftware.webshop.model.Users;
import org.springframework.data.repository.CrudRepository;
import de.jgsoftware.webshop.model.shoppingcart;
import java.util.List;

public interface i_dao_shoppingcart
{

    /*
        return the username
        and the id as list
        from table users in
        -> demodb
     */
    List<Users> getloggedinuserdata(String stusername);

    /*

        save
        id
        user_id
        and product_id

        into table shoppingcart
        -> shopdb
     */
    public List saveprodcut(List<shoppingcart> shoppingcart);
}
