package com.retailape.apps.vendormgr.mapper.service;

import java.util.ArrayList;
import java.util.List;

import org.appfuse.service.impl.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;

import com.retailape.apps.vendormgr.mapper.dao.ProductMapperDao;
import com.retailape.apps.vendormgr.mapper.filters.ProductMatcher;
import com.retailape.apps.vendormgr.mapper.model.VendorProductMap;
import com.retailape.apps.vendormgr.model.CSProducts;
import com.retailape.apps.vendormgr.model.VendorProducts;


public class ProductMapperManagerImpl extends GenericManagerImpl<VendorProductMap, Long> implements
		ProductMapperManager {
	
	private List<ProductMatcher> lstProductMatcher;
	
	ProductMapperDao productMapperDao;
	
	 @Autowired
    public ProductMapperManagerImpl(ProductMapperDao productMapperDao) {
        super(productMapperDao);     
        log.debug("is this constructor called");
        this.productMapperDao = productMapperDao;
    }

	
	public List<ProductMatcher> getLstProductMatcher() {
		return lstProductMatcher;
	}

	
	
	public void setLstProductMatcher(List<ProductMatcher> lstProductMatcher) {
		log.debug("setter called" + lstProductMatcher);
		this.lstProductMatcher = lstProductMatcher;
	}
	
	
	public List<VendorProductMap> matchProductcs(List<VendorProducts>  lstProducts)
	{
		List <VendorProductMap> lstProductMaping = new ArrayList<VendorProductMap>();
		ProductMatcher firstProductMatcher = lstProductMatcher.get(0);
		ProductMatcher productMatcher = firstProductMatcher;
		
		int size = lstProductMatcher.size();
		
		for (int i = 1; i < size; i++ )
		{
			productMatcher.setNextMatcher(lstProductMatcher.get(i));
			productMatcher = lstProductMatcher.get(i);
		}
		
		VendorProductMap productMap;
		for (VendorProducts vendorProducts: lstProducts)
		{
			List<CSProducts> lstCSProducts =  (firstProductMatcher.findProducts(vendorProducts));
			//log.debug("lstCSProducts " + lstCSProducts);
			if (null == lstCSProducts)
			{
				continue;
			}
			for (CSProducts csProducts: lstCSProducts)
			{
				productMap = new VendorProductMap();
				productMap.setCsProducts(csProducts);
				productMap.setVendorProducts(vendorProducts);
				lstProductMaping.add(productMap);
			}			
		}	
		
		return lstProductMaping;
	}

	@Override
	public List<VendorProductMap> saveAll(List<VendorProductMap> lstVendorProductMap) {
		log.debug("In service layer");
		List<VendorProductMap> lstUpdatedMapping = new ArrayList<VendorProductMap>();
		for (VendorProductMap productMap: lstVendorProductMap)
		{
			//log.debug("calling save" + productMap);
			productMap = save(productMap);
			lstUpdatedMapping.add(productMap);
		}
		log.debug("After Saving " +  lstUpdatedMapping);
		return lstUpdatedMapping;

	}

	public ProductMapperDao getProductMapperDao() {
		return productMapperDao;
	}

	@Autowired
	public void setProductMapperDao(ProductMapperDao productMapperDao) {
		this.productMapperDao = productMapperDao;
	}

}
