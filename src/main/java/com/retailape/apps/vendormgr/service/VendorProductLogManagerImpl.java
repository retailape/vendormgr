package com.retailape.apps.vendormgr.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.appfuse.service.impl.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retailape.apps.vendormgr.dao.VendorProductLogDao;
import com.retailape.apps.vendormgr.model.FileState;
import com.retailape.apps.vendormgr.model.VendorProductUploadLog;

@Service("vendorProductLogManager")
public class VendorProductLogManagerImpl extends GenericManagerImpl<VendorProductUploadLog, Long> implements
		VendorProductLogManager {
	
   VendorProductLogDao vendorProductLogDao;
   
  /* public VendorProductLogManagerImpl() {
       super();
   }*/

   @Autowired
    public VendorProductLogManagerImpl(VendorProductLogDao vendorProductLogDao) {
        super(vendorProductLogDao);     
        log.debug("is this constructor called");
        this.vendorProductLogDao = vendorProductLogDao;
    }


   @Autowired
	public void setVendorProductlogDao(VendorProductLogDao vendorProductLogDao) {
	    this.vendorProductLogDao = vendorProductLogDao;
	}
   
	@Override
	public List<VendorProductUploadLog> fetchNewUploads() {
		log.debug("in service layer");
		/*VendorProductUploadLog logObject = get(new Long(1));
		log.debug("in service layer 3" + logObject);*/
		 
		Map<String, Object> queryParams = new HashMap<String, Object>();
		queryParams.put("fileState", FileState.NEW.name());
		return vendorProductLogDao.findByNamedQuery("fetchByState", queryParams);
		
	}

}
