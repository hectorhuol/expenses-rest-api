package com.financial.analisys.expenses.rest.api.domain;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@XmlRootElement(name = "category")
@Document(collection = "categories")
public class CategoryBO {

	@Id
	private String categoryId;
	private String name;

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CategoryBO) {
			CategoryBO category = (CategoryBO) obj;
			return new EqualsBuilder().append(this.categoryId,
					category.categoryId).isEquals();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(categoryId).toHashCode();
	}
}