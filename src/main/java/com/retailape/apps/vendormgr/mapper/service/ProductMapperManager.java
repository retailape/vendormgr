package com.retailape.apps.vendormgr.mapper.service;

import java.util.List;

import org.appfuse.service.GenericManager;

import com.retailape.apps.vendormgr.mapper.model.VendorProductMap;
import com.retailape.apps.vendormgr.model.VendorProducts;

public interface ProductMapperManager extends GenericManager<VendorProductMap, Long> {

	List<VendorProductMap> saveAll(List<VendorProductMap> lstVendorProductMap);
	
	List<VendorProductMap> matchProductcs(List<VendorProducts>  lstProducts);
}
