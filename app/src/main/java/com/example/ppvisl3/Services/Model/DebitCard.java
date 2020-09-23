package com.example.ppvisl3.Services.Model;

public class DebitCard {
    private final CardNumber mCardNumber;
    private final int mPassword;
    private Money mMoney;

    public DebitCard(CardNumber cardNumber, int password, String currency) {
        mCardNumber = cardNumber;
        mPassword = password;
        mMoney = new Money(currency, 0);
    }

    public CardNumber getCardNumber() {
        return mCardNumber;
    }

    //returns money if password correct, else returns null
    public Money getMoneyOrNullIfWrongPassword(int password) {
        if (checkPassword(password)) return mMoney;
        else return null;
    }

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

    public Money withdrawMoneyOrNull(int password, double value){
        if (checkPassword(password)){
            if(this.mMoney.getValue() >= value){
                this.mMoney.addToTheAccount(-value);
                return new Money(this.mMoney.getCurrency(), value);
            }else {
                return null;
            }

        }
        return null;
    }

    public boolean checkPassword(int password){
        if (this.mPassword == password){
            return true;
        }
        return false;
    }
}
