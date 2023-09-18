package de.jgsoftware.webshop.dao;


import de.jgsoftware.webshop.dao.interfaces.shop.i_Index_Dao;
import de.jgsoftware.webshop.model.m_webtextlayout;
import de.jgsoftware.webshop.model.useragent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import de.jgsoftware.webshop.dao.interfaces.shop.i_jpa_webtextlayout;
import de.jgsoftware.webshop.model.jpa.shopdb.Webtextlayout;

import java.util.List;

/**
 *
 * @author hoscho
 */

@Repository
public class Dao_Index implements i_Index_Dao
{

    @Autowired
    @Qualifier(value = "shopJdbcTemplate")
    JdbcTemplate jtm2;

    // demodb
    @Autowired
    @Qualifier(value = "defaultJdbcTemplate")
    JdbcTemplate jtm;
    
    
   
    de.jgsoftware.webshop.dao.interfaces.shop.i_jpa_webtextlayout jpawebtextlayout;
    
    
     // returns all entriys from Table
    @Override
    public List<Webtextlayout> getPageLanguageText()
    {
        
        //List<m_webtextlayout> webtextlayouts = jtm2.query("select * from webtextlayout", new BeanPropertyRowMapper(m_webtextlayout.class));
        List<Webtextlayout> webtextlayouts = (List) jpawebtextlayout.findAll();
        
        return webtextlayouts;
    }


    @Override
    public useragent saveuseragent(useragent muagent)
    {


        Long countid = jtm.queryForObject("SELECT COUNT (*) FROM useragent", Long.class);

        if(countid == 0)
        {
            countid = Long.valueOf(1);
            muagent.setId(countid);
        }
        else if(countid > 0)
        {
            long l = countid + 1;
            muagent.setId(l);
        }


        jtm.update("insert into useragent " +
                        "(id, ipaddress, stbrowser, stbrowserversion, stsystem, stlanguage, datum, timestamp) " +
                        "values (?, ?, ?, ?, ?, ?, ?, ?)",
                muagent.getId(),
                muagent.getIpAddress(),
                muagent.getStbrowser(),
                muagent.getStbrowserversion(),
                muagent.getStsystem(),
                muagent.getStlanguage(),
                muagent.getDate(),
                muagent.getDate());


        return muagent;
    }
}
