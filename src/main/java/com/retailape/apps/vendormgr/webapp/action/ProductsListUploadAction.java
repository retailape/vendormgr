package com.retailape.apps.vendormgr.webapp.action;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import net.sf.jxls.reader.ReaderBuilder;
import net.sf.jxls.reader.XLSReadStatus;
import net.sf.jxls.reader.XLSReader;

import org.springframework.beans.factory.annotation.Autowired;

import com.retailape.apps.vendormgr.model.CSVendors;
import com.retailape.apps.vendormgr.model.FileState;
import com.retailape.apps.vendormgr.model.ProductInventoryState;
import com.retailape.apps.vendormgr.model.ProductState;
import com.retailape.apps.vendormgr.model.VendorProductUploadLog;
import com.retailape.apps.vendormgr.model.VendorProducts;
import com.retailape.apps.vendormgr.service.VendorProductLogManager;
import com.retailape.apps.vendormgr.service.VendorProductManager;

public class ProductsListUploadAction extends FileUploadAction {
	
	@Autowired
	private VendorProductManager vendorProdManager;
	
	@Autowired
	private VendorProductLogManager vendorProdLogManager;
	
	private static final String PRODUCTS = "products";
	
	public void setVendorProductMgr(VendorProductManager vendorProdManager) {
		this.vendorProdManager = vendorProdManager;
	}
	
	public void setVendorProdLogManager(VendorProductLogManager vendorProdLogManager) {
		this.vendorProdLogManager = vendorProdLogManager;
	}

	public String upload() throws Exception
	{
		String uploadStatus = super.upload();
		log.debug("upload status " + uploadStatus);
		if (SUCCESS.equals(uploadStatus))
		{
			String fileLocation = (String) getRequest().getAttribute(LOCATION);
			log.debug("fileLocation " + fileLocation);
			String userName = getRequest().getRemoteUser();
			log.debug("userName " + userName);
			
		//	User user = userManager.getUserByUsername(userName);
			
			
			String xmlConfig = getText("jxls.xml.config.prefix")+userName+".xml";
			String vendorId = getText("user.vendor."+userName);
			log.debug("vendorId " + vendorId);
			log.debug("xmlConfig " + xmlConfig);
			Map beans = new HashMap();
			//log file upload time & final link & uploaded by
	    	VendorProductUploadLog uploadLog = new VendorProductUploadLog();
			/*Set<VendorProducts> vendorProducts = new HashSet<VendorProducts>();
			vendorProducts.add(new VendorProducts());
			uploadLog.setVendorProducts(vendorProducts);
			beans.put(PRODUCTS, uploadLog);*/
	    	
	    	Set<VendorProducts> vendorProducts = new HashSet<VendorProducts>();
	    	beans.put(PRODUCTS, vendorProducts);
		//	log.debug("xmlConfig " + getClass().getResourceAsStream("ApplicationResources.properties"));
			//log.debug("xmlConfig " + getClass().getResourceAsStream(xmlConfig));
			InputStream inputXML = new BufferedInputStream(getClass().getResourceAsStream(xmlConfig));
			
			
		    XLSReader mainReader = ReaderBuilder.buildFromXML( inputXML );

			log.debug("mainReader " + mainReader);
			InputStream inputXLS = (new FileInputStream(fileLocation));
			log.debug("inputXLS " + inputXLS);
			XLSReadStatus readStatus = mainReader.read( inputXLS, beans);
			log.debug("readStatus " + readStatus);
			
			log.debug("vendorProducts " + vendorProducts);
			
	    	uploadLog.setNumberOfProducts(new Long(vendorProducts.size()));
	    	uploadLog.setUploadedBy(userName);
	    	uploadLog.setUploadLink(fileLocation);
	    	uploadLog.setUploadedOn(new Date());
	    	uploadLog.setFileStatus(FileState.NEW.toString());
	    	uploadLog.setUploadFileName(getFileFileName());
	    	CSVendors csVendor = new CSVendors();
	    	csVendor.setId(new Long(vendorId));
	    	uploadLog.setCsVendors(csVendor);
	    	
	    	
	    	for (VendorProducts vendorProduct : vendorProducts)
	    	{
	    		vendorProduct.setProductState(ProductState.NEW.name());
	    		vendorProduct.setProductInventoryState(ProductInventoryState.MEDIUM.name());
	    		vendorProduct.setCsVendors(csVendor);
	    		vendorProduct.setVendorProductUploadLog(uploadLog);
	    		//vendorProdManager.save(vendorProduct);
	    	}
	    	uploadLog.setVendorProducts(vendorProducts);
	    	vendorProdLogManager.save(uploadLog);
	    	
	    	//vendorProdLogManager.get(new Long(1));
	    	inputXLS.close();
	    	
			//vendorProdManager.upload((List<VendorProducts>) beans.get(PRODUCTS));
			return SUCCESS;
		}
		
		return uploadStatus;
	}
	
	//read xls uploaded using jxlsreader based on some configuration
	
	/*
    InputStream inputXLS = new BufferedInputStream(getClass().getResourceAsStream(dataXLS));
    Department department = new Department();
    Department hrDepartment = new Department();
    List departments = new ArrayList();
    Map beans = new HashMap();
    beans.put("department", department);
    beans.put("hrDepartment", hrDepartment);
    beans.put("departments", departments);
    XLSReadStatus readStatus = mainReader.read( inputXLS, beans);*/
	
	//save the beans in DB
	//call mgr & save
	
	//finally return to UI with products uploaded details.

}
