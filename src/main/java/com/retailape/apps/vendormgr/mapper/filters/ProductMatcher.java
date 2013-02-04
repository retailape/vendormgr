package com.retailape.apps.vendormgr.mapper.filters;

import java.util.List;

import com.retailape.apps.vendormgr.model.CSProducts;
import com.retailape.apps.vendormgr.model.VendorProducts;

public interface ProductMatcher {
	
	void setNextMatcher(ProductMatcher productMatcher);
	
	List<CSProducts> findProducts(VendorProducts products);
}
