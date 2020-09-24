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
        return this.mPassword == password;
    }
    public boolean checkPassword(String password){
        return password.equals(String.valueOf(this.mPassword));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[]{this.getCardNumber().toString(), String.valueOf(this.mPassword),
                this.mMoney.getCurrency(), String.valueOf(this.mMoney.getValue())});
    }

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
