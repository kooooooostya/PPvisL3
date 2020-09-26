package com.example.ppvisl3.Services.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class DebitCard implements Parcelable {
    private final CardNumber mCardNumber;
    private final int mPassword;
    private Money mMoney;

    public DebitCard(CardNumber cardNumber, int password, String currency) {
        mCardNumber = cardNumber;
        mPassword = password;
        mMoney = new Money(currency, 0);
    }

    public DebitCard(CardNumber cardNumber, int password, Money money) {
        mCardNumber = cardNumber;
        mPassword = password;
        mMoney = money;
    }

    public CardNumber getCardNumber() {
        return mCardNumber;
    }

    //returns money if password correct, else returns null
    public Money getMoney() {
        return mMoney;
    }

    public void setMoney(Money money) {
        mMoney = money;
    }

    //adds money to the card
    public void putMoneyToCard(Money money){
        switch (this.mMoney.getCurrency()) {
            case Money.USD:
                money.setUSDCurrency();
                break;
            case Money.BY:
                money.setBYCurrency();
                break;
            case Money.RUB:
                money.setRUBCurrency();
                break;
        }
        this.mMoney.addToTheAccount(money.getValue());
    }

    //returns money if there is more money on the card than is needed for withdrawal
    public Money withdrawMoneyOrNull(double value, String currency){
        Money money = new Money(currency, value);
        money.transferToAnotherCurrency(this.mMoney.getCurrency());
        if (this.mMoney.getValue() >= money.getValue()) {
            this.mMoney.addToTheAccount(-money.getValue(), money.getCurrency());
            return money;
        } else {
            return null;
        }
    }

    //checks password
    public boolean checkPassword(int password){
        return this.mPassword == password;
    }
    public boolean checkPassword(String password){
        return password.equals(String.valueOf(this.mPassword));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    //This needed to write DebitCard to parcelable to transfer to the Activity
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[]{this.getCardNumber().toString(), String.valueOf(this.mPassword),
                this.mMoney.getCurrency(), String.valueOf(this.mMoney.getValue())});
    }

    //Creates DebitCard from parcelable
    public static final  Parcelable.Creator<DebitCard> CREATOR = new Parcelable.Creator<DebitCard>(){

        @Override
        public DebitCard createFromParcel(Parcel source) {
            String[] strings = new String[4];
            source.readStringArray(strings);
            return new DebitCard(new CardNumber(Long.valueOf(strings[0])),
                    Integer.parseInt(strings[1]), new Money(strings[2], Double.parseDouble(strings[3])));
        }

        @Override
        public DebitCard[] newArray(int size) {
            return new DebitCard[size];
        }
    };
}
