package com.retailape.apps.vendormgr.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

import org.appfuse.model.BaseObject;
import org.hibernate.search.annotations.Indexed;

@Embeddable
@Indexed
@XmlRootElement
public class ProductDescriptionKey extends BaseObject {

	@ManyToOne @JoinColumn(name="PRODUCT_ID")
	private CSProducts csProduct;
	
	@Column(name="lang_code", length=255)
	private String langCode;

	public CSProducts getCsProduct() {
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
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((csProduct == null) ? 0 : csProduct.hashCode());
		result = prime * result
				+ ((langCode == null) ? 0 : langCode.hashCode());
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
		ProductDescriptionKey other = (ProductDescriptionKey) obj;
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
		return true;
	}

	@Override
	public String toString() {
		return "ProductDescriptionKey [csProduct=" + csProduct + ", langCode="
				+ langCode + "]";
	}

	
	
}
