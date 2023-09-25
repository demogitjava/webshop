package de.jgsoftware.webshop.model.jpa.demodb;

//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
import jakarta.persistence.*;

/**
 *
 * @author hoscho
 */

@Entity
//@Table(name = "DNS", schema = "ROOT", catalog = "DEMODB")
public class Dns {
	@Id
	private Integer id;

	private String forwarddns;
	private String reversedns;
	private String dnszone;
	private String dnstype;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getForwarddns() {
		return forwarddns;
	}

	public void setForwarddns(String forwarddns) {
		this.forwarddns = forwarddns;
	}

	public String getReversedns() {
		return reversedns;
	}

	public void setReversedns(String reversedns) {
		this.reversedns = reversedns;
	}

	public String getDnszone() {
		return dnszone;
	}

	public void setDnszone(String dnszone) {
		this.dnszone = dnszone;
	}

	public String getDnstype() {
		return dnstype;
	}

	public void setDnstype(String dnstype) {
		this.dnstype = dnstype;
	}

}
