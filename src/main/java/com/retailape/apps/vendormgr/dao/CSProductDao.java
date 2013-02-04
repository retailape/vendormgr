package com.retailape.apps.vendormgr.dao;

import java.util.List;

import org.appfuse.dao.GenericDao;

import com.retailape.apps.vendormgr.mapper.model.VendorProductMap;
import com.retailape.apps.vendormgr.model.CSProducts;

public interface CSProductDao extends GenericDao<CSProducts, Long> {
	
//	List<CSProducts>  findByCriteria(ProductSearchCriterion criterion);

	List<CSProducts> findbyEANorUPC(String EAN, String UPC);

	List<CSProducts> findByCode(String productCode);

}
