package com.retailape.apps.vendormgr.dao;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

import com.retailape.apps.vendormgr.model.VendorProducts;

@Repository("vendorProductDao")
public class VendorProductDaoImpl extends GenericDaoHibernate<VendorProducts, Long> implements VendorProductDao {


	public VendorProductDaoImpl() {
		super(VendorProducts.class);
	}



}
