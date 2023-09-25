package de.jgsoftware.webshop.dao.interfaces.shop;

import org.springframework.data.domain.Pageable;

import java.util.List;

import de.jgsoftware.webshop.model.jpa.shopdb.Products;

/**
 *
 * @author hoscho
 */
public interface i_dao_products {
	/*
	 * load all products with selectected 1 in database
	 */
	List<Products> getProductsforLandingpage();

	/*
	 * select product by id
	 */
	Products getProductById(long productId);

	/*
	 * search product over Textfield in the webshop
	 */
	List<Products> searchProductovertextfield(String searchProduct, Pageable pageable);

	/*
	 * search product for pages display in webshop
	 */
	List<Products> searchProductop25(String searchProduct);
}
