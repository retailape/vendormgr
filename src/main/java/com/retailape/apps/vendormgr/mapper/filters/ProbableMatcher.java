package com.retailape.apps.vendormgr.mapper.filters;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.appfuse.dao.SearchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retailape.apps.vendormgr.dao.CSProductDao;
import com.retailape.apps.vendormgr.model.CSProducts;
import com.retailape.apps.vendormgr.model.VendorProducts;

@Service("probableMatcher")
public class ProbableMatcher  implements ProductMatcher {
	
	protected final Log log = LogFactory.getLog(getClass());
	
	private ProductMatcher nextMatcher;
	
	@Autowired
	private CSProductDao csProductDao;

	public void setNextMatcher(ProductMatcher nextMatcher) {
		this.nextMatcher = nextMatcher;
	}

	public List<CSProducts> findProducts(VendorProducts products)
	{
		//find product if found exit else move to next in line
		log.debug("products.getProductCode() " + products.getProductCode());
		List<CSProducts> lstCSProducts;
		try {
			lstCSProducts = csProductDao.search(products.getProductCode());
			log.debug("lstCSProducts " + lstCSProducts);
			if ((lstCSProducts == null || lstCSProducts.isEmpty()) && (nextMatcher != null))
			{
				lstCSProducts = nextMatcher.findProducts(products);
			}
		} catch (SearchException e) {
			return null;
		}
		
		return lstCSProducts;
	}

	public CSProductDao getCsProductDao() {
		return csProductDao;
	}

	@Autowired
	public void setCsProductDao(CSProductDao csProductDao) {
		this.csProductDao = csProductDao;
	}
	
}
