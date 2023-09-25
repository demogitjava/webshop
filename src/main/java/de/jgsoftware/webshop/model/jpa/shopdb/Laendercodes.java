package de.jgsoftware.webshop.model.jpa.shopdb;

//import javax.persistence.Column;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

import jakarta.persistence.*;

/**
 *
 * @author hoscho
 */

@Entity
public class Laendercodes {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id")
	private Integer id;

	private String land;

	private String code1;

	private String code2;

	private String eu;

	private Integer intlangdb;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLand() {
		return land;
	}

	public void setLand(String land) {
		this.land = land;
	}

	public String getCode1() {
		return code1;
	}

	public void setCode1(String code1) {
		this.code1 = code1;
	}

	public String getCode2() {
		return code2;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
	}

	public String getEu() {
		return eu;
	}

	public void setEu(String eu) {
		this.eu = eu;
	}

	public Integer getIntlangdb() {
		return intlangdb;
	}

	public void setIntlangdb(Integer intlangdb) {
		this.intlangdb = intlangdb;
	}

}
