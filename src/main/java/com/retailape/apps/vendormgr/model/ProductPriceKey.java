package com.retailape.apps.vendormgr.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.appfuse.model.BaseObject;

@Embeddable
public class ProductPriceKey extends BaseObject {

	@ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name="PRODUCT_ID")
	private CSProducts csProduct;
	
	@Column(name="usergroup_id")
	private Integer userGroupId;
	
	@Column(name="lower_limit", length=1)
	private Integer lowerLimit;

	public CSProducts getCsProduct() {
		return csProduct;
	}

	public void setCsProduct(CSProducts csProduct) {
		this.csProduct = csProduct;
	}

	public Integer getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(Integer userGroupId) {
		this.userGroupId = userGroupId;
	}

	public Integer getLowerLimit() {
		return lowerLimit;
	}

	public void setLowerLimit(Integer lowerLimit) {
		this.lowerLimit = lowerLimit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((csProduct == null) ? 0 : csProduct.hashCode());
		result = prime * result
				+ ((lowerLimit == null) ? 0 : lowerLimit.hashCode());
		result = prime * result
				+ ((userGroupId == null) ? 0 : userGroupId.hashCode());
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
		ProductPriceKey other = (ProductPriceKey) obj;
		if (csProduct == null) {
			if (other.csProduct != null)
				return false;
		} else if (!csProduct.equals(other.csProduct))
			return false;
		if (lowerLimit == null) {
			if (other.lowerLimit != null)
				return false;
		} else if (!lowerLimit.equals(other.lowerLimit))
			return false;
		if (userGroupId == null) {
			if (other.userGroupId != null)
				return false;
		} else if (!userGroupId.equals(other.userGroupId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProductPriceKey [csProduct=" + csProduct + ", userGroupId="
				+ userGroupId + ", lowerLimit=" + lowerLimit + "]";
	}
	

}
