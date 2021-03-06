package com.example.ppvisl3;

import com.example.ppvisl3.Services.Model.CardNumber;
import com.example.ppvisl3.Services.Model.DebitCard;
import com.example.ppvisl3.Services.Model.Money;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class DebitCardTest {

    DebitCard mDebitCard;
    CardNumber mCardNumber;

    @Before
    public void setUp() throws Exception {
        mCardNumber = new CardNumber();
        mDebitCard = new DebitCard(mCardNumber, 222, Money.BY);
    }

    @Test
    public void getCardNumber() {
        Assert.assertEquals(mCardNumber.getCardNumber(), mDebitCard.getCardNumber().getCardNumber());
    }

    @Test
    public void withdrawMoney() {
        assertNull(mDebitCard.withdrawMoneyOrNull(20000, Money.BY));
        Money money = new Money(Money.BY, 100);
        mDebitCard.putMoneyToCard(money);
        assertEquals(100, Math.round(mDebitCard.
                withdrawMoneyOrNull(100, Money.BY).getValue()));
    }

    @Test
    public void setMoney() {
    }

    @Test
    public void checkPassword() {
        assertFalse(mDebitCard.checkPassword(22));
        assertFalse(mDebitCard.checkPassword(2232));
        assertTrue(mDebitCard.checkPassword(222));
    }

    @Test
    public void putMoneyToCard() {
        Money money = new Money(Money.BY, 100);
        mDebitCard.putMoneyToCard(money);
        Assert.assertEquals(100, Math.round(mDebitCard.getMoney().getValue()));
    }
}