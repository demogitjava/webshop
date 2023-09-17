package de.jgsoftware.webshop.dao.interfaces.shop;

import de.jgsoftware.landingpage.model.jpa.shopdb.Webtextlayout;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hoscho
 */
@Repository
public interface i_jpa_webtextlayout extends JpaRepository<Webtextlayout, Integer>
{
    
}
