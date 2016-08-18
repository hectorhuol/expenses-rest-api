package com.financial.analisys.expenses.rest.api.domain;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@XmlRootElement(name = "card")
@Document(collection = "cards")
public class CardBO {

	@Id
	private String cardId;
	private String name;
	private CardTypeBO type;

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CardTypeBO getType() {
		return type;
	}

	public void setType(CardTypeBO type) {
		this.type = type;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CardBO) {
			CardBO card = (CardBO) obj;
			return new EqualsBuilder().append(this.cardId, card.cardId)
					.isEquals();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(cardId).toHashCode();
	}
}