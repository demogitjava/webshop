package de.jgsoftware.webshop.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import de.jgsoftware.webshop.dao.interfaces.shop.i_dao_shoppingcart;
import de.jgsoftware.webshop.model.Users;
import de.jgsoftware.webshop.model.shoppingcart;

/**
 *
 * @author hoscho
 */

@Repository
public class Dao_shoppingcart implements i_dao_shoppingcart {

	@Autowired
	@Qualifier(value = "shopJdbcTemplate")
	JdbcTemplate jtm2;

	// demodb
	@Autowired
	@Qualifier(value = "defaultJdbcTemplate")
	JdbcTemplate jtm;

	public Dao_shoppingcart(@Qualifier(value = "defaultJdbcTemplate") JdbcTemplate jtm,
			@Qualifier(value = "shopJdbcTemplate") JdbcTemplate jtm2) {
		this.jtm = jtm;
		this.jtm2 = jtm2;
	}

	@Override
	public List<Users> getloggedinuserdata(String stusername) {

		// SELECT * FROM USERS where username like 'admin'
		List<Users> getcurrentuser = jtm.query("SELECT * FROM USERS where username like " + "'" + stusername + "'",
				new BeanPropertyRowMapper(Users.class));
		return getcurrentuser;
	}

	/*
	 * 
	 * save userproduct to shoppingcart
	 */
	@Override
	public List saveprodcut(List<shoppingcart> shoppingcart) {

		Integer id = 1;

		Integer user_id = shoppingcart.get(0).getUser_id();
		Long product_id = shoppingcart.get(0).getProduct_id();

		int countid = jtm2.queryForObject("select count(id) from SHOPPINGCART", Integer.class);

		if (countid == 0) {
			id = 1;
		} else {
			id = countid + 1;
		}
		// shopdb
		jtm2.update("INSERT INTO SHOPPINGCART (id, user_id, product_id) VALUES (?, ?, ?)", id, user_id, product_id);
		return shoppingcart;
	}
}
