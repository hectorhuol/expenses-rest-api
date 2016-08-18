package com.financial.analisys.expenses.rest.api.domain;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@XmlRootElement(name = "companion")
@Document(collection = "companions")
public class CompanionBO {

	@Id
	private String companionId;
	private String name;
	private String alias;

	public String getCompanionId() {
		return companionId;
	}

	public void setCompanionId(String companionId) {
		this.companionId = companionId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CompanionBO) {
			CompanionBO companion = (CompanionBO) obj;
			return new EqualsBuilder().append(this.companionId,
					companion.companionId).isEquals();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(companionId).toHashCode();
	}
}