package com.retailape.apps.vendormgr.mapper.dao;

import java.util.List;

import org.appfuse.model.BaseObject;

import com.retailape.apps.vendormgr.mapper.vo.ProductSearchCriteria;

public class ProductSearchCriterion extends BaseObject {

	private ProductSearchCriteria searchCriteria;
	private String searchCondition;
	private ProductSearchCriterion criterion;
	private List<ProductSearchCriterion> criterions;
	
	
	
	public ProductSearchCriteria getSearchCriteria() {
		return searchCriteria;
	}

	public void setSearchCriteria(ProductSearchCriteria searchCriteria) {
		this.searchCriteria = searchCriteria;
	}

	public String getSearchCondition() {
		return searchCondition;
	}

	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	public ProductSearchCriterion getCriterion() {
		return criterion;
	}

	public void setCriterion(ProductSearchCriterion criterion) {
		this.criterion = criterion;
	}

	public List<ProductSearchCriterion> getCriterions() {
		return criterions;
	}

	public void setCriterions(List<ProductSearchCriterion> criterions) {
		this.criterions = criterions;
	}

	@Override
	public String toString() {
		return "ProductSearchCriterion [searchCriteria=" + searchCriteria
				+ ", searchCondition=" + searchCondition + ", criterion="
				+ criterion + ", criterions=" + criterions + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((criterion == null) ? 0 : criterion.hashCode());
		result = prime * result
				+ ((criterions == null) ? 0 : criterions.hashCode());
		result = prime * result
				+ ((searchCondition == null) ? 0 : searchCondition.hashCode());
		result = prime * result
				+ ((searchCriteria == null) ? 0 : searchCriteria.hashCode());
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
		ProductSearchCriterion other = (ProductSearchCriterion) obj;
		if (criterion == null) {
			if (other.criterion != null)
				return false;
		} else if (!criterion.equals(other.criterion))
			return false;
		if (criterions == null) {
			if (other.criterions != null)
				return false;
		} else if (!criterions.equals(other.criterions))
			return false;
		if (searchCondition == null) {
			if (other.searchCondition != null)
				return false;
		} else if (!searchCondition.equals(other.searchCondition))
			return false;
		if (searchCriteria == null) {
			if (other.searchCriteria != null)
				return false;
		} else if (!searchCriteria.equals(other.searchCriteria))
			return false;
		return true;
	}

	
	
	
}
