package com.financial.analisys.expenses.rest.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.financial.analisys.expenses.rest.api.domain.CardBO;
import com.financial.analisys.expenses.rest.api.service.CardService;

@RestController
public class CardController {

	@Autowired
	private CardService cardService;

	@RequestMapping(path = "/card", method = RequestMethod.POST)
	public CardBO createCard(@RequestBody CardBO cardBO) {
		return cardService.createCard(cardBO);
	}

	@RequestMapping(path = "/card", method = RequestMethod.PUT)
	public void updateCard(@RequestBody CardBO cardBO) {
		cardService.updateCard(cardBO);
	}

	@RequestMapping(path = "/card/{id}", method = RequestMethod.DELETE)
	public void deleteCard(@PathVariable String id) {
		cardService.deleteCard(id);
	}

	@RequestMapping(path = "/card/{id}", method = RequestMethod.GET)
	public CardBO getCard(@PathVariable String id) {
		return cardService.getCard(id);
	}

	@RequestMapping(path = "/card", method = RequestMethod.GET)
	public List<CardBO> getAllCards() {
		return cardService.getAllCards();
	}
}
