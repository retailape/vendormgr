package com.retailape.apps.vendormgr.dao;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

import com.retailape.apps.vendormgr.model.VendorProductUploadLog;

@Repository("vendorProductLogDao")
public class VendorProductLogDaoImpl extends GenericDaoHibernate<VendorProductUploadLog, Long> implements VendorProductLogDao {

	public VendorProductLogDaoImpl() {
		super(VendorProductUploadLog.class);
		//log.debug("getSession()  " + getSession());
	}
	
	

	/*@Override
	public List<VendorProductUploadLog> findByNamedQuery(String queryName,
			Map<String, Object> queryParams) {
		log.debug("getting Session()");
		//log.debug("getSession()  " + getSession());
		Query namedQuery = getSession().getNamedQuery(queryName);
		log.debug("namedQuery  " + namedQuery);
		return findByNamedQuery(queryName, queryParams);
	}*/
}
