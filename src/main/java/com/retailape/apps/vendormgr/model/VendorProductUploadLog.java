package com.retailape.apps.vendormgr.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.appfuse.model.BaseObject;

@NamedQueries({
@NamedQuery(
name="fetchByState",
query="from VendorProductUploadLog s where s.fileStatus = :fileState"
)})

@Entity
@Table(name="vendor_upload_log")
public class VendorProductUploadLog extends BaseObject {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="upload_FILE_name", length=255)
	private String uploadFileName;
	
	@Column(name="upload_file_link", length=255)
	private String uploadLink;
	
	@Column(name="NUM_OF_PRODS")
	private Long numberOfProducts;
	
	@Column(name="file_state", columnDefinition="Varchar(50) default 'PRESENT'")
	private String fileStatus;
	
	@Column(name="uploaded_By", length=255)
	private String uploadedBy;
	
	@Column(name="uploaded_on", columnDefinition="datetime")
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date uploadedOn;

	@ManyToOne @JoinColumn(name="csVendors_id")
    private CSVendors csVendors;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vendorProductUploadLog", cascade=CascadeType.ALL)
    private Set<VendorProducts> vendorProducts;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadLink() {
		return uploadLink;
	}

	public void setUploadLink(String uploadLink) {
		this.uploadLink = uploadLink;
	}

	public String getFileStatus() {
		return fileStatus;
	}

	public void setFileStatus(String fileStatus) {
		this.fileStatus = fileStatus;
	}

	public String getUploadedBy() {
		return uploadedBy;
	}

	public void setUploadedBy(String uploadedBy) {
		this.uploadedBy = uploadedBy;
	}

	public Date getUploadedOn() {
		return uploadedOn;
	}

	public void setUploadedOn(Date uploadedOn) {
		this.uploadedOn = uploadedOn;
	}

	public CSVendors getCsVendors() {
		return csVendors;
	}

	public void setCsVendors(CSVendors csVendors) {
		this.csVendors = csVendors;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((csVendors == null) ? 0 : csVendors.hashCode());
		result = prime * result
				+ ((fileStatus == null) ? 0 : fileStatus.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((uploadFileName == null) ? 0 : uploadFileName.hashCode());
		result = prime * result
				+ ((uploadLink == null) ? 0 : uploadLink.hashCode());
		result = prime * result
				+ ((uploadedBy == null) ? 0 : uploadedBy.hashCode());
		result = prime * result
				+ ((uploadedOn == null) ? 0 : uploadedOn.hashCode());
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
		VendorProductUploadLog other = (VendorProductUploadLog) obj;
		if (csVendors == null) {
			if (other.csVendors != null)
				return false;
		} else if (!csVendors.equals(other.csVendors))
			return false;
		if (fileStatus != other.fileStatus)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (uploadFileName == null) {
			if (other.uploadFileName != null)
				return false;
		} else if (!uploadFileName.equals(other.uploadFileName))
			return false;
		if (uploadLink == null) {
			if (other.uploadLink != null)
				return false;
		} else if (!uploadLink.equals(other.uploadLink))
			return false;
		if (uploadedBy == null) {
			if (other.uploadedBy != null)
				return false;
		} else if (!uploadedBy.equals(other.uploadedBy))
			return false;
		if (uploadedOn == null) {
			if (other.uploadedOn != null)
				return false;
		} else if (!uploadedOn.equals(other.uploadedOn))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VendorProductUploadLog [id=" + id + ", uploadFileName="
				+ uploadFileName + ", uploadLink=" + uploadLink
				+ ", fileStatus=" + fileStatus + ", uploadedBy=" + uploadedBy
				+ ", uploadedOn=" + uploadedOn + ", csVendors=" + csVendors
				+ "]";
	}

	public Long getNumberOfProducts() {
		return numberOfProducts;
	}

	public void setNumberOfProducts(Long numberOfProducts) {
		this.numberOfProducts = numberOfProducts;
	}

	public Set<VendorProducts> getVendorProducts() {
		return vendorProducts;
	}

	public void setVendorProducts(Set<VendorProducts> vendorProducts) {
		this.vendorProducts = vendorProducts;
	}
	


}
