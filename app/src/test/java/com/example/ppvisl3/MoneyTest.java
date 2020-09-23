package com.example.ppvisl3;

import com.company.Money;
import com.company.Rate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MoneyTest {

    Money mUSD;
    Money mRUB;
    Money mBYN;

    @Before
    public void setUp(){
        mBYN = new Money(Money.BY, 50);
        mRUB = new Money(Money.RUB, 50);
        mUSD = new Money(Money.USD, 50);
    }

    @Test
    public void setUSDCurrency() {
        mUSD.setUSDCurrency();
        mRUB.setUSDCurrency();
        mBYN.setUSDCurrency();

        Rate rate = new Rate();
        Assert.assertEquals((int)mUSD.getValue(), 50);
        Assert.assertEquals(Math.round(mBYN.getValue()), Math.round(50 / rate.getRateBY()));
        Assert.assertEquals(Math.round(mRUB.getValue()), Math.round(50 / rate.getRateRUB()));
    }

    @Test
    public void setBYCurrency() {
        mUSD.setBYCurrency();
        mRUB.setBYCurrency();
        mBYN.setBYCurrency();

        Rate rate = new Rate();
        Assert.assertEquals((int)mBYN.getValue(), 50);
        Assert.assertEquals(Math.round(mUSD.getValue()), Math.round(50 * rate.getRateBY()));
        Assert.assertEquals(Math.round(mRUB.getValue()), Math.round((50 / rate.getRateRUB() * rate.getRateBY())));
    }

    @Test
    public void setRUBCurrency() {
        mUSD.setRUBCurrency();
        mRUB.setRUBCurrency();
        mBYN.setRUBCurrency();

        Rate rate = new Rate();
        Assert.assertEquals((int)mRUB.getValue(), 50);
        Assert.assertEquals(Math.round(mUSD.getValue()), Math.round(50 * rate.getRateRUB()));
        Assert.assertEquals(Math.round(mBYN.getValue()), Math.round((50 / rate.getRateBY() * rate.getRateRUB())));
    }

}