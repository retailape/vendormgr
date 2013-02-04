package com.retailape.apps.vendormgr.dao;

import java.util.List;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.retailape.apps.vendormgr.model.CSProducts;

@Repository("csProductDao")
public class CSProductDaoImpl extends GenericDaoHibernate<CSProducts, Long> implements
		CSProductDao {
	
	public CSProductDaoImpl() {
		super(CSProducts.class);
	}


	@Override
	public List<CSProducts> findbyEANorUPC(String EAN, String UPC) {
		Session sess = getSession();
		Criteria crit = sess.createCriteria(CSProducts.class);		
		crit.add(Restrictions.or(Restrictions.eq("EAN", EAN), Restrictions.eq("UPC", UPC)));		
		return crit.list();
	}
	
	@Override
	public List<CSProducts> findByCode(String code) {
		Session sess = getSession();
		Criteria crit = sess.createCriteria(CSProducts.class);		
		crit.add(Restrictions.eq("productCode", code));		
		return crit.list();
	}
	
	
}
