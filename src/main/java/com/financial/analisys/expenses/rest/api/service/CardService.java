package com.financial.analisys.expenses.rest.api.service;

import java.util.List;

import com.financial.analisys.expenses.rest.api.domain.CardBO;

public interface CardService {

	CardBO createCard(CardBO cardBO);

	void updateCard(CardBO cardBO);

	void deleteCard(String id);

	CardBO getCard(String id);

	List<CardBO> getAllCards();

}
