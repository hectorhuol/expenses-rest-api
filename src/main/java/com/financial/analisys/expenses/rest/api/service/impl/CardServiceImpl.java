package com.financial.analisys.expenses.rest.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financial.analisys.expenses.api.domain.Card;
import com.financial.analisys.expenses.rest.api.domain.CardBO;
import com.financial.analisys.expenses.rest.api.service.CardService;
import com.financial.analisys.expenses.rest.api.service.expensesImpl.ExpensesAPIFacade;
import com.financial.analisys.expenses.rest.api.utils.BOUtils;

@Service
public class CardServiceImpl implements CardService {

	@Autowired
	private ExpensesAPIFacade expensesAPIFacade;

	@Override
	public CardBO createCard(CardBO cardBO) {
		Card card = expensesAPIFacade.getCardsManager().createCard(
				BOUtils.transformObject(cardBO, Card.class));
		cardBO.setCardId(card.getCardId());
		return cardBO;
	}

	@Override
	public void updateCard(CardBO cardBO) {
		expensesAPIFacade.getCardsManager().updateCard(
				BOUtils.transformObject(cardBO, Card.class));
	}

	@Override
	public void deleteCard(String id) {
		Card card = new Card();
		card.setCardId(id);
		expensesAPIFacade.getCardsManager().deleteCard(card);
	}

	@Override
	public CardBO getCard(String id) {
		Card card = new Card();
		card.setCardId(id);
		card = expensesAPIFacade.getCardsManager().getCard(card);
		return BOUtils.transformObject(card, CardBO.class);
	}

	@Override
	public List<CardBO> getAllCards() {
		List<Card> cards = expensesAPIFacade.getCardsManager().getAllCards();
		return BOUtils.transformObjectList(cards, CardBO.class);
	}

}
