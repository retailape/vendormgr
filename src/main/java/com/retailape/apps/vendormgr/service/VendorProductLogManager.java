package com.retailape.apps.vendormgr.service;

import java.util.List;

import org.appfuse.service.GenericManager;

import com.retailape.apps.vendormgr.model.VendorProductUploadLog;

public interface VendorProductLogManager extends GenericManager<VendorProductUploadLog, Long> {
	
	//void upload(List<VendorProducts> lstVendorProds, String userName, String vendorId);

	List<VendorProductUploadLog> fetchNewUploads();
}
