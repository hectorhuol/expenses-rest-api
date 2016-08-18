package com.financial.analisys.expenses.rest.api;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.financial.analisys.expenses.api.domain.Card;
import com.financial.analisys.expenses.api.domain.Category;
import com.financial.analisys.expenses.api.domain.Companion;
import com.financial.analisys.expenses.api.domain.Expense;
import com.financial.analisys.expenses.api.domain.User;
import com.financial.analisys.expenses.rest.api.domain.CardBO;
import com.financial.analisys.expenses.rest.api.domain.CardTypeBO;
import com.financial.analisys.expenses.rest.api.domain.CategoryBO;
import com.financial.analisys.expenses.rest.api.domain.CompanionBO;
import com.financial.analisys.expenses.rest.api.domain.ExpenseBO;
import com.financial.analisys.expenses.rest.api.domain.UserBO;
import com.financial.analisys.expenses.rest.api.utils.BOUtils;

public class BOUtilsTest {

	@Test
	public void testCardTransformation() {

		try {
			CardBO cardBO = new CardBO();
			cardBO.setCardId("1");
			cardBO.setName("name");
			cardBO.setType(CardTypeBO.CREDIT);
			Card card = BOUtils.transformObject(cardBO, Card.class);
			Assert.assertEquals(card.getCardId(), cardBO.getCardId());
			Assert.assertEquals(card.getName(), cardBO.getName());
			Assert.assertEquals(card.getType().name(), cardBO.getType().name());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testCategoryTransformation() {

		try {
			CategoryBO categoryBO = new CategoryBO();
			categoryBO.setCategoryId("1");
			categoryBO.setName("name");
			Category category = BOUtils.transformObject(categoryBO,
					Category.class);
			Assert.assertEquals(category.getCategoryId(),
					categoryBO.getCategoryId());
			Assert.assertEquals(category.getName(), categoryBO.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testCompanionTransformation() {

		try {
			CompanionBO companionBO = new CompanionBO();
			companionBO.setCompanionId("1");
			companionBO.setName("name");
			companionBO.setAlias("alias");
			Companion companion = BOUtils.transformObject(companionBO,
					Companion.class);
			Assert.assertEquals(companion.getCompanionId(),
					companionBO.getCompanionId());
			Assert.assertEquals(companion.getName(), companionBO.getName());
			Assert.assertEquals(companion.getAlias(), companionBO.getAlias());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testUserTransformation() {

		try {
			UserBO userBO = new UserBO();
			userBO.setUserId("1");
			userBO.setUserName("name");
			userBO.setPassword("12345");
			User user = BOUtils.transformObject(userBO, User.class);
			Assert.assertEquals(user.getUserId(), userBO.getUserId());
			Assert.assertEquals(user.getUserName(), userBO.getUserName());
			Assert.assertEquals(user.getPassword(), userBO.getPassword());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testExpenseTransformation() {

		try {
			CardBO cardBO = new CardBO();
			cardBO.setCardId("1");
			cardBO.setName("name");
			cardBO.setType(CardTypeBO.CREDIT);

			CategoryBO categoryBO = new CategoryBO();
			categoryBO.setCategoryId("1");
			categoryBO.setName("name");

			CompanionBO companionBO = new CompanionBO();
			companionBO.setCompanionId("1");
			companionBO.setName("name");
			companionBO.setAlias("alias");

			UserBO userBO = new UserBO();
			userBO.setUserId("1");
			userBO.setUserName("name");
			userBO.setPassword("12345");

			ExpenseBO expenseBO = new ExpenseBO();
			expenseBO.setExpenseId("1");
			expenseBO.setValue(10.0);
			expenseBO.setCity("city");
			expenseBO.setDateAndHour("10/10/10 10:10:10");
			expenseBO.setLocation("location");
			expenseBO.setCard(cardBO);
			expenseBO.setCategory(categoryBO);
			expenseBO.getCompanions().add(companionBO);
			expenseBO.setUser(userBO);

			Expense expense = BOUtils.transformObject(expenseBO, Expense.class);
			Assert.assertEquals(expense.getExpenseId(),
					expenseBO.getExpenseId());
			Assert.assertEquals(expense.getValue(), expenseBO.getValue());
			Assert.assertEquals(expense.getCity(), expenseBO.getCity());
			Assert.assertEquals(expense.getDateAndHour(),
					expenseBO.getDateAndHour());
			Assert.assertEquals(expense.getLocation(), expenseBO.getLocation());
			Assert.assertEquals(expense.getCard().getCardId(), expenseBO
					.getCard().getCardId());
			Assert.assertEquals(expense.getCategory().getCategoryId(),
					expenseBO.getCategory().getCategoryId());
			Assert.assertEquals(
					expense.getCompanions().get(0).getCompanionId(), expenseBO
							.getCompanions().get(0).getCompanionId());
			Assert.assertEquals(expense.getUser().getUserId(), expenseBO
					.getUser().getUserId());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testCardListTransformation() {

		try {
			CardBO cardBO = new CardBO();
			cardBO.setCardId("1");
			cardBO.setName("name");
			cardBO.setType(CardTypeBO.CREDIT);
			CardBO cardBO2 = new CardBO();
			cardBO2.setCardId("2");
			cardBO2.setName("name2");
			cardBO2.setType(CardTypeBO.DEBIT);

			List<CardBO> cardsBO = new ArrayList<CardBO>();
			cardsBO.add(cardBO);
			cardsBO.add(cardBO2);

			List<Card> cards = BOUtils.transformObjectList(cardsBO, Card.class);
			Assert.assertEquals(cards.size(), cardsBO.size());
			Assert.assertEquals(cards.get(0).getCardId(), cardsBO.get(0)
					.getCardId());
			Assert.assertEquals(cards.get(0).getName(), cardsBO.get(0)
					.getName());
			Assert.assertEquals(cards.get(0).getType().name(), cardsBO.get(0)
					.getType().name());
			Assert.assertEquals(cards.get(1).getCardId(), cardsBO.get(1)
					.getCardId());
			Assert.assertEquals(cards.get(1).getName(), cardsBO.get(1)
					.getName());
			Assert.assertEquals(cards.get(1).getType().name(), cardsBO.get(1)
					.getType().name());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testExcludeFieldsTransformation() {

		try {
			CardBO cardBO = new CardBO();
			cardBO.setCardId("1");
			cardBO.setName("name");
			cardBO.setType(CardTypeBO.CREDIT);

			CategoryBO categoryBO = new CategoryBO();
			categoryBO.setCategoryId("1");
			categoryBO.setName("name");

			CompanionBO companionBO = new CompanionBO();
			companionBO.setCompanionId("1");
			companionBO.setName("name");
			companionBO.setAlias("alias");

			UserBO userBO = new UserBO();
			userBO.setUserId("1");
			userBO.setUserName("name");
			userBO.setPassword("12345");

			ExpenseBO expenseBO = new ExpenseBO();
			expenseBO.setExpenseId("1");
			expenseBO.setValue(10.0);
			expenseBO.setCity("city");
			expenseBO.setDateAndHour("10/10/10 10:10:10");
			expenseBO.setLocation("location");
			expenseBO.setCard(cardBO);
			expenseBO.setCategory(categoryBO);
			expenseBO.getCompanions().add(companionBO);
			expenseBO.setUser(userBO);

			Expense expense = BOUtils.transformObject(expenseBO, Expense.class,
					new String[] { "password" });
			Assert.assertEquals(expense.getUser().getPassword(), null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testExcludeFieldsListTransformation() {

		try {
			CardBO cardBO = new CardBO();
			cardBO.setCardId("1");
			cardBO.setName("name");
			cardBO.setType(CardTypeBO.CREDIT);
			CardBO cardBO2 = new CardBO();
			cardBO2.setCardId("2");
			cardBO2.setName("name2");
			cardBO2.setType(CardTypeBO.DEBIT);

			List<CardBO> cardsBO = new ArrayList<CardBO>();
			cardsBO.add(cardBO);
			cardsBO.add(cardBO2);

			List<Card> cards = BOUtils.transformObjectList(cardsBO, Card.class,
					new String[] { "name" });
			Assert.assertEquals(cards.size(), cardsBO.size());
			Assert.assertEquals(cards.get(0).getCardId(), cardsBO.get(0)
					.getCardId());
			Assert.assertEquals(cards.get(0).getName(), null);
			Assert.assertEquals(cards.get(0).getType().name(), cardsBO.get(0)
					.getType().name());
			Assert.assertEquals(cards.get(1).getCardId(), cardsBO.get(1)
					.getCardId());
			Assert.assertEquals(cards.get(1).getName(), null);
			Assert.assertEquals(cards.get(1).getType().name(), cardsBO.get(1)
					.getType().name());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
