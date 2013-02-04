package com.retailape.apps.vendormgr.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.appfuse.model.BaseObject;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

@Entity
@Table(name="cscart_products")
@Indexed
@XmlRootElement
public class CSProducts extends BaseObject {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO ) 
	@Column(name = "product_id")
	private Long productId;
	
	@Column(name="product_code", length=255)
	private String productCode;
	
	@Column(name="list_price")
	private Double listPrice;
	
	@Column(name="status", length=1)
	private String status;
	
	@ManyToOne @JoinColumn(name="company_id")
    private CSVendors csVendors;
	

	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "key.csProduct", cascade=CascadeType.ALL)
	private Set<CSProductPrices> csProductPrices;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "key.csProduct", cascade = CascadeType.ALL)
	private Set<CSProductDescriptions> productDescriptions;
	
	
/*	@OneToOne(fetch = FetchType.LAZY, mappedBy = "csProduct", cascade = CascadeType.ALL)
	private CSProductDescriptions productDescriptions;*/
	
	/*@OneToOne(fetch = FetchType.LAZY, mappedBy = "csProducts", cascade = CascadeType.ALL)
	private VendorProducts vendorProducts;*/
	

/*	@Field
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}*/

	@Field(analyze=Analyze.NO)
	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}


/*	public String getEAN() {
		return EAN;
	}

	public void setEAN(String eAN) {
		EAN = eAN;
	}

	public String getUPC() {
		return UPC;
	}

	public void setUPC(String uPC) {
		UPC = uPC;
	}
*/


	public CSVendors getCsVendors() {
		return csVendors;
	}

	public void setCsVendors(CSVendors csVendors) {
		this.csVendors = csVendors;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Double getListPrice() {
		return listPrice;
	}

	public void setListPrice(Double listPrice) {
		this.listPrice = listPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((csVendors == null) ? 0 : csVendors.hashCode());
		result = prime * result
				+ ((listPrice == null) ? 0 : listPrice.hashCode());
		result = prime * result
				+ ((productCode == null) ? 0 : productCode.hashCode());
		result = prime * result
				+ ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CSProducts other = (CSProducts) obj;
		if (csVendors == null) {
			if (other.csVendors != null)
				return false;
		} else if (!csVendors.equals(other.csVendors))
			return false;
		if (listPrice == null) {
			if (other.listPrice != null)
				return false;
		} else if (!listPrice.equals(other.listPrice))
			return false;
		if (productCode == null) {
			if (other.productCode != null)
				return false;
		} else if (!productCode.equals(other.productCode))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CSProducts [productId=" + productId + ", productCode="
				+ productCode + ", listPrice=" + listPrice + ", status="
				+ status + ", csVendors=" + csVendors + "]";
	}



	public Set<CSProductPrices> getCsProductPrices() {
		return csProductPrices;
	}

	public void setCsProductPrices(Set<CSProductPrices> csProductPrices) {
		this.csProductPrices = csProductPrices;
	}

	public Set<CSProductDescriptions>  getProductDescriptions() {
		return productDescriptions;
	}

	public void setProductDescriptions(
			Set<CSProductDescriptions> productDescriptions) {
		this.productDescriptions = productDescriptions;
	}
	
/*	public VendorProducts getVendorProducts() {
		return vendorProducts;
	}

	public void setVendorProducts(VendorProducts vendorProducts) {
		this.vendorProducts = vendorProducts;
	}
*/


}
