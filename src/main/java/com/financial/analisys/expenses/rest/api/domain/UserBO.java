package com.financial.analisys.expenses.rest.api.domain;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@XmlRootElement(name = "user")
@Document(collection = "users")
public class UserBO {

	@Id
	private String userId;
	private String userName;
	private String password;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String alias) {
		this.password = alias;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof UserBO) {
			UserBO user = (UserBO) obj;
			return new EqualsBuilder().append(this.userId, user.userId)
					.isEquals();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(userId).toHashCode();
	}
}