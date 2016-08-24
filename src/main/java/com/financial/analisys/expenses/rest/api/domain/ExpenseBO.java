package com.financial.analisys.expenses.rest.api.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@XmlRootElement(name = "expense")
@Document(collection = "expenses")
public class ExpenseBO {

	@Id
	private String expenseId;
	private Double value;
	private String dateAndHour;
	@DBRef
	private List<CompanionBO> companions;
	@DBRef
	private CardBO card;
	@DBRef
	private CategoryBO category;
	@DBRef
	private UserBO user;
	private String location;
	private String city;

	public String getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(String expenseId) {
		this.expenseId = expenseId;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public String getDateAndHour() {
		return dateAndHour;
	}

	public void setDateAndHour(String dateAndHour) {
		this.dateAndHour = dateAndHour;
	}

	public List<CompanionBO> getCompanions() {
		if (companions != null)
			return companions;
		else
			companions = new ArrayList<>();
		return companions;
	}

	public void setCompanions(List<CompanionBO> companions) {
		this.companions = companions;
	}

	public CardBO getCard() {
		return card;
	}

	public void setCard(CardBO card) {
		this.card = card;
	}

	public UserBO getUser() {
		return user;
	}

	public void setUser(UserBO user) {
		this.user = user;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public CategoryBO getCategory() {
		return category;
	}

	public void setCategory(CategoryBO category) {
		this.category = category;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ExpenseBO) {
			ExpenseBO expense = (ExpenseBO) obj;
			return new EqualsBuilder()
					.append(this.expenseId, expense.expenseId).isEquals();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(expenseId).toHashCode();
	}
}