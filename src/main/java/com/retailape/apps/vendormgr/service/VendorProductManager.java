package com.retailape.apps.vendormgr.service;

import java.util.List;

import org.appfuse.service.GenericManager;

import com.retailape.apps.vendormgr.model.VendorProducts;

public interface VendorProductManager extends GenericManager<VendorProducts, Long> {
	
	void saveAll(List<VendorProducts> lstVendorProds);

	List<VendorProducts> fetchNewProductsInBatch(Long batchId);

}
