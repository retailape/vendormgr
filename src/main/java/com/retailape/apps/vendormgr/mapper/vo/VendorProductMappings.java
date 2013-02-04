package com.retailape.apps.vendormgr.mapper.vo;

import java.util.List;

import com.retailape.apps.vendormgr.model.CSProducts;
import com.retailape.apps.vendormgr.model.VendorProducts;

public class VendorProductMappings {
	
	private Long id;
	private VendorProducts vendorProducts;
	private List<CSProducts> lstCSProducts;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public VendorProducts getVendorProducts() {
		return vendorProducts;
	}
	public void setVendorProducts(VendorProducts vendorProducts) {
		this.vendorProducts = vendorProducts;
	}
	public List<CSProducts> getLstCSProducts() {
		return lstCSProducts;
	}
	public void setLstCSProducts(List<CSProducts> lstCSProducts) {
		this.lstCSProducts = lstCSProducts;
	}
	
	

}
