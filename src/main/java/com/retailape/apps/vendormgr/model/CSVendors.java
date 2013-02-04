package com.retailape.apps.vendormgr.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.appfuse.model.BaseObject;

@Entity
@Table(name="cscart_companies")
public class CSVendors extends BaseObject {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="company_id")
	private Long id;
	
	@Column(name="company", length=255)
	private String vendorName;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "csVendors", cascade=CascadeType.ALL)
	private Set<VendorProductUploadLog> vendorProductUploadLogs;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "csVendors", cascade=CascadeType.ALL)
	private Set<CSProducts> csProducts;

	public Long getId() {
		return id;
	}

	public void setId(Long vendorId) {
		this.id = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((vendorName == null) ? 0 : vendorName.hashCode());
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
		CSVendors other = (CSVendors) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (vendorName == null) {
			if (other.vendorName != null)
				return false;
		} else if (!vendorName.equals(other.vendorName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CSVendors [vendorId=" + id + ", vendorName="
				+ vendorName + "]";
	}

	public Set<VendorProductUploadLog> getVendorProductUploadLogs() {
		return vendorProductUploadLogs;
	}

	public void setVendorProductUploadLogs(
			Set<VendorProductUploadLog> vendorProductUploadLogs) {
		this.vendorProductUploadLogs = vendorProductUploadLogs;
	}

	public Set<CSProducts> getCsProducts() {
		return csProducts;
	}

	public void setCsProducts(Set<CSProducts> csProducts) {
		this.csProducts = csProducts;
	}



}
