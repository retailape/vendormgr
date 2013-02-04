package com.retailape.apps.vendormgr.service;

import java.util.List;

import org.appfuse.service.impl.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retailape.apps.vendormgr.dao.CSProductDao;
import com.retailape.apps.vendormgr.model.CSProducts;

@Service("csProductManager")
public class CSProductManagerImpl extends GenericManagerImpl<CSProducts, Long> implements
		CSProductManager {	
	
   CSProductDao csProductDao;

   @Autowired
    public CSProductManagerImpl(CSProductDao csProductDao) {
        super(csProductDao);
        log.debug("is this constructor called");
        this.csProductDao = csProductDao;
    }   

	@Override
	public void saveAll(List<CSProducts> lstVendorProds) {
		for (CSProducts vendorProducts : lstVendorProds)
		{
			save(vendorProducts);
		}
		
	}

	@Autowired
	public void setCsProductDao(CSProductDao csProductDao) {
		this.csProductDao = csProductDao;
	}
}
