package com.financial.analisys.expenses.rest.api.service.expensesImpl.gateway;

import java.util.List;

import com.financial.analisys.expenses.api.domain.Card;
import com.financial.analisys.expenses.api.gateways.CardsGateway;
import com.financial.analisys.expenses.rest.api.domain.CardBO;
import com.financial.analisys.expenses.rest.api.exceptions.NoDataFoundException;
import com.financial.analisys.expenses.rest.api.repository.CardRepository;
import com.financial.analisys.expenses.rest.api.utils.BOUtils;

public class RestAPICardsGatewayImpl implements CardsGateway {

	private CardRepository cardRepository;

	public RestAPICardsGatewayImpl(CardRepository cardRepository) {
		this.cardRepository = cardRepository;
	}

	@Override
	public Card createCard(Card card) {
		CardBO cardBO = cardRepository.save(BOUtils.transformObject(card,
				CardBO.class));
		if (isObjectNull(cardBO)) {
			card.setCardId(cardBO.getCardId());
			return card;
		}
		throw new NoDataFoundException("No data found");
	}

	@Override
	public void updateCard(Card card) {
		cardRepository.save(BOUtils.transformObject(card, CardBO.class));
	}

	@Override
	public void deleteCard(Card card) {
		cardRepository.delete(BOUtils.transformObject(card, CardBO.class));
	}

	@Override
	public Card getCard(Card card) {
		CardBO cardBO = cardRepository.findOne(card.getCardId());
		if (isObjectNull(cardBO))
			return BOUtils.transformObject(cardBO, Card.class);
		throw new NoDataFoundException("No data found");
	}

	@Override
	public List<Card> getAllCards() {
		List<CardBO> list = cardRepository.findAll();
		if (isObjectNull(list))
			return BOUtils.transformObjectList(list, Card.class);
		throw new NoDataFoundException("No data found");
	}

	private boolean isObjectNull(Object object) {
		return object != null;
	}
}