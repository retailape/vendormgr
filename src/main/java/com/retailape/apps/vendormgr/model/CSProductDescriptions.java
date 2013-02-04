package com.retailape.apps.vendormgr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.appfuse.model.BaseObject;
import org.hibernate.search.annotations.Field;

@Entity
@Table(name="cscart_product_descriptions")
public class CSProductDescriptions extends BaseObject {
	
	@Id
	private ProductDescriptionKey key;

/*	@GenericGenerator(name = "generator", strategy = "foreign", 
	parameters = @Parameter(name = "property", value = "csProduct"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "PRODUCT_ID", unique = true, nullable = false)	
	public Integer getProductId() {
		return this.productId;
	}
 
	
	
	@OneToOne @PrimaryKeyJoinColumn
	private CSProducts csProduct;
	
	@Column(name="lang_code", length=255)
	private String langCode;*/
	
	
	@Column(name="product", length=255)
	private String product;
	
	@Column(name="search_words", length=4000)
	private String searchWords;

	
	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	
	public String getSearchWords() {
		return searchWords;
	}

	public void setSearchWords(String searchWords) {
		this.searchWords = searchWords;
	}

	public ProductDescriptionKey getKey() {
		return key;
	}

	public void setKey(ProductDescriptionKey key) {
		this.key = key;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result
				+ ((searchWords == null) ? 0 : searchWords.hashCode());
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
		CSProductDescriptions other = (CSProductDescriptions) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (searchWords == null) {
			if (other.searchWords != null)
				return false;
		} else if (!searchWords.equals(other.searchWords))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CSProductDescriptions [key=" + key + ", product=" + product
				+ ", searchWords=" + searchWords + "]";
	}

	/*public CSProducts getCsProduct() {
		return csProduct;
	}

	public void setCsProduct(CSProducts csProduct) {
		this.csProduct = csProduct;
	}

	public String getLangCode() {
		return langCode;
	}

	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}*/

/*	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((csProduct == null) ? 0 : csProduct.hashCode());
		result = prime * result
				+ ((langCode == null) ? 0 : langCode.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result
				+ ((searchWords == null) ? 0 : searchWords.hashCode());
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
		CSProductDescriptions other = (CSProductDescriptions) obj;
		if (csProduct == null) {
			if (other.csProduct != null)
				return false;
		} else if (!csProduct.equals(other.csProduct))
			return false;
		if (langCode == null) {
			if (other.langCode != null)
				return false;
		} else if (!langCode.equals(other.langCode))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (searchWords == null) {
			if (other.searchWords != null)
				return false;
		} else if (!searchWords.equals(other.searchWords))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CSProductDescriptions [csProduct=" + csProduct + ", langCode="
				+ langCode + ", product=" + product + ", searchWords="
				+ searchWords + "]";
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}*/




	

}
