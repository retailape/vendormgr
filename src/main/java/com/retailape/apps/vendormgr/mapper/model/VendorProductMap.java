package com.retailape.apps.vendormgr.mapper.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.appfuse.model.BaseObject;

import com.retailape.apps.vendormgr.model.CSProducts;
import com.retailape.apps.vendormgr.model.VendorProducts;

@Entity
@Table(name="vendor_products_map")
public class VendorProductMap extends BaseObject {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO) 
	private Long id;
	@ManyToOne @PrimaryKeyJoinColumn
	private VendorProducts vendorProducts;
	@ManyToOne @PrimaryKeyJoinColumn
	private CSProducts csProducts;
	

	public VendorProducts getVendorProducts() {
		return vendorProducts;
	}

	public void setVendorProducts(VendorProducts vendorProducts) {
		this.vendorProducts = vendorProducts;
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CSProducts getCsProducts() {
		return csProducts;
	}

	public void setCsProducts(CSProducts csProducts) {
		this.csProducts = csProducts;
	}

	@Override
	public String toString() {
		return "VendorProductMap [id=" + id + ", vendorProducts="
				+ vendorProducts + ", csProducts=" + csProducts + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((csProducts == null) ? 0 : csProducts.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((vendorProducts == null) ? 0 : vendorProducts.hashCode());
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
		VendorProductMap other = (VendorProductMap) obj;
		if (csProducts == null) {
			if (other.csProducts != null)
				return false;
		} else if (!csProducts.equals(other.csProducts))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (vendorProducts == null) {
			if (other.vendorProducts != null)
				return false;
		} else if (!vendorProducts.equals(other.vendorProducts))
			return false;
		return true;
	}



}
