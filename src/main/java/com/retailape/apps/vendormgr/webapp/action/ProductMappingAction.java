package com.retailape.apps.vendormgr.webapp.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.retailape.apps.vendormgr.mapper.model.VendorProductMap;
import com.retailape.apps.vendormgr.mapper.service.ProductMapperManager;
import com.retailape.apps.vendormgr.mapper.vo.VendorProductMappings;
import com.retailape.apps.vendormgr.model.CSProductPrices;
import com.retailape.apps.vendormgr.model.CSProducts;
import com.retailape.apps.vendormgr.model.ProductPriceKey;
import com.retailape.apps.vendormgr.model.ProductState;
import com.retailape.apps.vendormgr.model.VendorProductUploadLog;
import com.retailape.apps.vendormgr.model.VendorProducts;
import com.retailape.apps.vendormgr.service.CSProductManager;
import com.retailape.apps.vendormgr.service.VendorProductLogManager;
import com.retailape.apps.vendormgr.service.VendorProductManager;

public class ProductMappingAction extends BaseAction {

	private List<VendorProducts> lstProducts;
	private List<VendorProductMap> lstProductMaping;
	private List<VendorProductUploadLog> lstVendorProductUploadLogs;
	private List<VendorProducts> lstVendorProducts;
	private List<VendorProductMappings> lstVendorProductMappings;
	private List<Long> lstMatchingProductIds;
	
	private Long id;
	
	@Autowired
	private VendorProductLogManager vendorProductLogManager;
	
	@Autowired
	private VendorProductManager vendorProductManager;

	@Autowired
	private CSProductManager csProductManager;
	
	@Autowired
	private ProductMapperManager productMapperManager;
	 
	

	public String matchProducts()
	{
		HttpServletRequest request = getRequest();
		lstVendorProducts = (List<VendorProducts>) request.getSession().getAttribute("lstVendorProducts");
		lstProductMaping = productMapperManager.matchProductcs(lstVendorProducts);
		lstProductMaping = productMapperManager.saveAll(lstProductMaping);
		lstVendorProductMappings = new ArrayList<VendorProductMappings>();
		VendorProducts product = null;
		List<CSProducts> lstCSProducts = null;
		for (VendorProductMap productMap: lstProductMaping)
		{
			if (product == null || product.getId() != productMap.getVendorProducts().getId())
			{
				VendorProductMappings mapping = new VendorProductMappings();
				lstVendorProductMappings.add(mapping);
				mapping.setId(productMap.getVendorProducts().getId());
				mapping.setVendorProducts(productMap.getVendorProducts());
				lstCSProducts = new ArrayList<CSProducts>();
				lstCSProducts.add(productMap.getCsProducts());
				mapping.setLstCSProducts(lstCSProducts);
				product = productMap.getVendorProducts();
			}
			else
			{
				lstCSProducts.add(productMap.getCsProducts());
			}
		}
		request.getSession().setAttribute("hints", lstVendorProductMappings);
		return SUCCESS;
	}
	
	public String fetchBatches()
	{
		//fetch New batches
		lstVendorProductUploadLogs = vendorProductLogManager.fetchNewUploads();
		return SUCCESS;
	}
	
	public String fetchProductsofBatch()
	{		//fetch New batches
		log.debug("batch id " + id);
		
		lstVendorProducts = vendorProductManager.fetchNewProductsInBatch(id);
		HttpServletRequest request = getRequest();
		request.getSession().setAttribute("lstVendorProducts", lstVendorProducts);
		return SUCCESS;
	}
	


	/**
	 * approves exact matching of the products & finally vendor & 
	 * products relationship is established
	 * @return
	 */
	public String approveVendorProducts()
	{
		//List<Long> lstMatchingProductIds = new ArrayList<Long>();
		log.debug("lstMatchingProductIds " + lstMatchingProductIds);
		List<CSProducts> lstCSProducts = new ArrayList<CSProducts>();
		List<VendorProducts> lstVProducts = new ArrayList<VendorProducts>();
		HttpServletRequest request = getRequest();
		lstVendorProductMappings = (List<VendorProductMappings>) request.getSession().getAttribute("hints");
		int inx = 1;
		for (VendorProductMappings vendorPrdctMapping : lstVendorProductMappings)
		{
			VendorProducts vendorProduct = vendorPrdctMapping.getVendorProducts();
			List<CSProducts> lstCSPList =  vendorPrdctMapping.getLstCSProducts();
			for (CSProducts csProduct : lstCSPList)
			{
				log.debug("lstMatchingProductIds.get(inx) " + lstMatchingProductIds.get(inx));
				log.debug("csProduct.getId_product() " + csProduct.getProductId());
				log.debug("is it matching?  " + (csProduct.getProductId() == lstMatchingProductIds.get(inx)));
				if (csProduct.getProductId().equals(lstMatchingProductIds.get(inx)))
				{
					log.debug("vendorProduct.getCsVendors() " + vendorProduct.getCsVendors());
					csProduct.setCsVendors(vendorProduct.getCsVendors());
					csProduct.setStatus("A");
					csProduct.setListPrice(vendorProduct.getMRP());
					//csProduct.setQ(vendorProduct.getMRP());
					CSProductPrices productPrice = new CSProductPrices();
					productPrice.setPrice(vendorProduct.getRSP());
					ProductPriceKey priceKey = new ProductPriceKey();
					priceKey.setCsProduct(csProduct);
					priceKey.setLowerLimit(1);
					priceKey.setUserGroupId(0);
					productPrice.setKey(priceKey);
					Set<CSProductPrices> productPrices = new HashSet<CSProductPrices>();
					productPrices.add(productPrice);
				//	vendorProduct.setCsProducts(csProduct);
					csProduct.setCsProductPrices(productPrices);
					vendorProduct.setIdProduct(csProduct.getProductId());
					vendorProduct.setProductState(ProductState.UPLOADED.name());
					lstVProducts.add(vendorProduct);
					//csProduct.setVendorProducts(vendorProduct);
					lstCSProducts.add(csProduct);
				}
			}
			inx++;
			
		}
		csProductManager.saveAll(lstCSProducts);
		
		vendorProductManager.saveAll(lstVProducts);
		return SUCCESS;
	}

	public List<VendorProducts> getLstProducts() {
		return lstProducts;
	}

	public void setLstProducts(List<VendorProducts> lstProducts) {
		this.lstProducts = lstProducts;
	}

	public List<VendorProductMap> getLstProductMaping() {
		return lstProductMaping;
	}

	public void setLstProductMaping(List<VendorProductMap> lstProductMaping) {
		this.lstProductMaping = lstProductMaping;
	}

	public List<VendorProductUploadLog> getLstVendorProductUploadLogs() {
		return lstVendorProductUploadLogs;
	}

	public void setLstVendorProductUploadLogs(
			List<VendorProductUploadLog> lstVendorProductUploadLogs) {
		this.lstVendorProductUploadLogs = lstVendorProductUploadLogs;
	}

	public List<VendorProducts> getLstVendorProducts() {
		return lstVendorProducts;
	}

	public void setLstVendorProducts(List<VendorProducts> lstVendorProducts) {
		
		log.debug("lstVendorProducts " + lstVendorProducts);
		this.lstVendorProducts = lstVendorProducts;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long batchId) {
		this.id = batchId;
	}



	public ProductMapperManager getProductMapperManager() {
		return productMapperManager;
	}

	@Autowired
	public void setProductMapperManager(ProductMapperManager productMapperManager) {
		this.productMapperManager = productMapperManager;
	}

	

	public VendorProductManager getVendorProductManager() {
		return vendorProductManager;
	}
	
	@Autowired
	public void setVendorProductManager(VendorProductManager vendorProductManager) {
		this.vendorProductManager = vendorProductManager;
	}


	@Autowired
	public void setVendorProductLogManager(VendorProductLogManager vendorProdLogManager) {
		this.vendorProductLogManager = vendorProdLogManager;
	}

	public List<VendorProductMappings> getLstVendorProductMappings() {
		return lstVendorProductMappings;
	}

	public void setLstVendorProductMappings(
			List<VendorProductMappings> lstVendorProductMappings) {
		this.lstVendorProductMappings = lstVendorProductMappings;
	}

	public List<Long> getLstMatchingProductIds() {
		return lstMatchingProductIds;
	}

	public void setLstMatchingProductIds(List<Long> lstMatchingProductIds) {
		this.lstMatchingProductIds = lstMatchingProductIds;
	}

	@Autowired
	public void setCsProductManager(CSProductManager csProductManager) {
		this.csProductManager = csProductManager;
	}
	
}
