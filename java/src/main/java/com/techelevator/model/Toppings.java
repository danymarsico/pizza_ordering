package com.techelevator.model;

import java.math.BigDecimal;

public class Toppings {

    private String toppingName ="";
    private BigDecimal additionalPrice = new BigDecimal("0.00");
    private boolean isPremium = false;

    public Toppings() {};

    public Toppings(String toppingName, BigDecimal additionalPrice, boolean isPremium) {
        this.toppingName = toppingName;
        this.additionalPrice = additionalPrice;
        this.isPremium = isPremium;
    }

    public String getToppingName() {
        return toppingName;
    }

    public void setToppingName(String toppingName) {
        this.toppingName = toppingName;
    }

    public BigDecimal getAdditionalPrice() {
        return additionalPrice;
    }

    public void setAdditionalPrice(BigDecimal additionalPrice) {
        this.additionalPrice = additionalPrice;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }

    @Override
    public String toString() {
        return "Toppings{" +
                "toppingName='" + toppingName + '\'' +
                ", additionalPrice=" + additionalPrice +
                ", isPremium=" + isPremium +
                '}';
    }
}
