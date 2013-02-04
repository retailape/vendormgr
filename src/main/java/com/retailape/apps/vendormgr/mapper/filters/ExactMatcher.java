package com.retailape.apps.vendormgr.mapper.filters;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retailape.apps.vendormgr.dao.CSProductDao;
import com.retailape.apps.vendormgr.model.CSProducts;
import com.retailape.apps.vendormgr.model.VendorProducts;

@Service("exactMatcher")
public class ExactMatcher implements ProductMatcher {
	
	protected final Log log = LogFactory.getLog(getClass());
	private ProductMatcher nextMatcher;
	
	@Autowired
	private CSProductDao csProductDao;
	
	
	public void setNextMatcher(ProductMatcher nextMatcher) {
		this.nextMatcher = nextMatcher;
	}

	public List<CSProducts> findProducts(VendorProducts products)
	{
		log.debug("in exact matcher..");
		//find product if found exit else move to next in line
		List<CSProducts> lstCSProducts = csProductDao.findByCode(products.getProductCode());
		log.debug("lstCSProducts " + lstCSProducts);
		if ((lstCSProducts == null || lstCSProducts.isEmpty()) && (nextMatcher != null))
		{
			lstCSProducts = nextMatcher.findProducts(products);
		}
		
		return lstCSProducts;
	}

	public CSProductDao getCsProductDao() {
		return csProductDao;
	}

	public void setCsProductDao(CSProductDao csProductDao) {
		this.csProductDao = csProductDao;
	}

}
