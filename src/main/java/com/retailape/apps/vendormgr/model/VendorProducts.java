package com.retailape.apps.vendormgr.model;

import javax.persistence.*;

@NamedQueries({
@NamedQuery(
name="fetchByStateAndBatch",
query="from VendorProducts s where s.productState = :productState and s.vendorProductUploadLog.id = :uploadLogId"
)})

@Entity
@Table(name="vendor_products")
public class VendorProducts extends org.appfuse.model.BaseObject {
	

	@Id @GeneratedValue(strategy = GenerationType.AUTO) 
	private Long id;
	
	/*@OneToOne (cascade = CascadeType.ALL) 
	@JoinColumn(name="C_ID_PRODUCT")*/
   // private CSProducts csProducts;

	@Column(name="C_ID_PRODUCT")
	private Long idProduct;

	@Column(name="product_name", length=255)
	private String productName;
	
	@Column(name="product_code", length=255)
	private String productCode;
	
	@Column(name="UPC", length=15)
	private String UPC;
	
	@Column(name="EAN", length=15)
	private String EAN;
	
	@Column(name="ASIN", length=15)
	private String ASIN;
	
	@Column(name="RSP")
	private Double RSP;
	
	@Column(name="MRP")
	private Double MRP;
	
	@Column(name="IMAGE_URL", length=255)
	private String imageURL;
	
	@Column(name="description", length=4000)
	private String description;
	
	@Column(name="short_desc", length=400)
	private String shortDesc;
	
	@Column(name="vendor_code", length=50)
	private String key;
	
	@Column(name="product_state", columnDefinition="Varchar(50) default 'New'")
	private String productState;
	
	@Column(name="product_inv_state",length=50)
	private String productInventoryState;
	
	@ManyToOne @JoinColumn(name="csVendors_id")
    private CSVendors csVendors;
	
	@ManyToOne @PrimaryKeyJoinColumn
    private VendorProductUploadLog vendorProductUploadLog;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	

/*	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn*/
	/*public CSProducts getCsProducts() {
		return csProducts;
	}
	
	public void setCsProducts(CSProducts csProducts) {
		this.csProducts = csProducts;
	}*/
	public CSVendors getCsVendors() {
		return csVendors;
	}
	public void setCsVendors(CSVendors csVendors) {
		this.csVendors = csVendors;
	}

	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getUPC() {
		return UPC;
	}
	public void setUPC(String uPC) {
		UPC = uPC;
	}
	public String getEAN() {
		return EAN;
	}
	public void setEAN(String eAN) {
		EAN = eAN;
	}
	public String getASIN() {
		return ASIN;
	}
	public void setASIN(String aSIN) {
		ASIN = aSIN;
	}
	public Double getRSP() {
		return RSP;
	}
	public void setRSP(Double rSP) {
		RSP = rSP;
	}
	public Double getMRP() {
		return MRP;
	}
	public void setMRP(Double mRP) {
		MRP = mRP;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getShortDesc() {
		return shortDesc;
	}
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	public String getProductState() {
		return productState;
	}
	public void setProductState(String productState) {
		this.productState = productState;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ASIN == null) ? 0 : ASIN.hashCode());
		result = prime * result + ((EAN == null) ? 0 : EAN.hashCode());
		result = prime * result + ((MRP == null) ? 0 : MRP.hashCode());
		result = prime * result + ((RSP == null) ? 0 : RSP.hashCode());
		result = prime * result + ((UPC == null) ? 0 : UPC.hashCode());
		/*result = prime * result
				+ ((csProducts == null) ? 0 : csProducts.hashCode());*/
		result = prime * result
				+ ((csVendors == null) ? 0 : csVendors.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((imageURL == null) ? 0 : imageURL.hashCode());
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result
				+ ((productCode == null) ? 0 : productCode.hashCode());
		result = prime * result
				+ ((productName == null) ? 0 : productName.hashCode());
		result = prime * result
				+ ((shortDesc == null) ? 0 : shortDesc.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VendorProducts other = (VendorProducts) obj;
		if (ASIN == null) {
			if (other.ASIN != null)
				return false;
		} else if (!ASIN.equals(other.ASIN))
			return false;
		if (EAN == null) {
			if (other.EAN != null)
				return false;
		} else if (!EAN.equals(other.EAN))
			return false;
		if (MRP == null) {
			if (other.MRP != null)
				return false;
		} else if (!MRP.equals(other.MRP))
			return false;
		if (RSP == null) {
			if (other.RSP != null)
				return false;
		} else if (!RSP.equals(other.RSP))
			return false;
		if (UPC == null) {
			if (other.UPC != null)
				return false;
		} else if (!UPC.equals(other.UPC))
			return false;
		/*if (csProducts == null) {
			if (other.csProducts != null)
				return false;
		} else if (!csProducts.equals(other.csProducts))
			return false;*/
		if (csVendors == null) {
			if (other.csVendors != null)
				return false;
		} else if (!csVendors.equals(other.csVendors))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (imageURL == null) {
			if (other.imageURL != null)
				return false;
		} else if (!imageURL.equals(other.imageURL))
			return false;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (productCode == null) {
			if (other.productCode != null)
				return false;
		} else if (!productCode.equals(other.productCode))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (shortDesc == null) {
			if (other.shortDesc != null)
				return false;
		} else if (!shortDesc.equals(other.shortDesc))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "VendorProducts [id=" + id + ", csProducts=" //+ csProducts
				+ ", productName=" + productName + ", productCode="
				+ productCode + ", UPC=" + UPC + ", EAN=" + EAN + ", ASIN="
				+ ASIN + ", RSP=" + RSP + ", MRP=" + MRP + ", imageURL="
				+ imageURL + ", description=" + description + ", shortDesc="
				+ shortDesc + ", key=" + key + ", csVendors=" + csVendors + "]";
	}
	public VendorProductUploadLog getVendorProductUploadLog() {
		return vendorProductUploadLog;
	}
	public void setVendorProductUploadLog(
			VendorProductUploadLog vendorProductUploadLog) {
		this.vendorProductUploadLog = vendorProductUploadLog;
	}
	public String getProductInventoryState() {
		return productInventoryState;
	}
	public void setProductInventoryState(String productInventoryState) {
		this.productInventoryState = productInventoryState;
	}
	public Long getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}

	
}
