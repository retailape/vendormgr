package com.retailape.apps.vendormgr.service;

import java.util.List;

import org.appfuse.service.GenericManager;

import com.retailape.apps.vendormgr.model.CSProducts;

public interface CSProductManager extends GenericManager<CSProducts, Long> {
	
	void saveAll(List<CSProducts> lstCSProds);

}
