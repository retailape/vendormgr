package com.retailape.apps.vendormgr.mapper.dao;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

import com.retailape.apps.vendormgr.mapper.model.VendorProductMap;

@Repository("productMapperDao")
public class ProductMapperDaoImpl extends GenericDaoHibernate<VendorProductMap, Long> implements
		ProductMapperDao {
	
	public ProductMapperDaoImpl() {
		super(VendorProductMap.class);
	}
	
	
	
}
