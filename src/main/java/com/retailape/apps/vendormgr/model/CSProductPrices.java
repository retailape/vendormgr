package com.retailape.apps.vendormgr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.appfuse.model.BaseObject;

@Entity
@Table(name="cscart_product_prices")
public class CSProductPrices extends BaseObject {
	
	@Id
	private ProductPriceKey key;
	
	@Column(name="price")
	private Double price;
	
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}



	public ProductPriceKey getKey() {
		return key;
	}

	public void setKey(ProductPriceKey key) {
		this.key = key;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
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
		CSProductPrices other = (CSProductPrices) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CSProductPrices [key=" + key + ", price=" + price + "]";
	}

}
