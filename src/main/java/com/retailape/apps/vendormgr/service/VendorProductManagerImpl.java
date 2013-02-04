package com.retailape.apps.vendormgr.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.appfuse.service.impl.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retailape.apps.vendormgr.dao.VendorProductDao;
import com.retailape.apps.vendormgr.model.ProductState;
import com.retailape.apps.vendormgr.model.VendorProducts;

@Service("vendorProductManager")
public class VendorProductManagerImpl extends GenericManagerImpl<VendorProducts, Long> implements
		VendorProductManager {	
	
   VendorProductDao vendorProductDao;

   @Autowired
    public VendorProductManagerImpl(VendorProductDao vendorProductDao) {
        super(vendorProductDao);
        log.debug("is this constructor called");
        this.vendorProductDao = vendorProductDao;
    }

	@Autowired
	public void setVendorProductDao(VendorProductDao vendorProductDao) {
		this.vendorProductDao = vendorProductDao;
	}

	@Override
	public List<VendorProducts> fetchNewProductsInBatch(Long batchId) {
		log.debug("finding products");
		Map<String, Object> queryParams = new HashMap<String, Object>();
		queryParams.put("productState", ProductState.NEW.name());
		queryParams.put("uploadLogId", batchId);
		return vendorProductDao.findByNamedQuery("fetchByStateAndBatch", queryParams);
	}

	@Override
	public void saveAll(List<VendorProducts> lstVendorProds) {
		for (VendorProducts vendorProducts : lstVendorProds)
		{
			save(vendorProducts);
		}
		
	}
}
