package com.techelevator.model;

import java.math.BigDecimal;

public class Sauce {
   private String sauceName;
   private BigDecimal saucePrice;

    public Sauce(String sauceName, BigDecimal saucePrice) {
        this.sauceName = sauceName;
        this.saucePrice = saucePrice;
    }
    public Sauce() {}

    public String getSauceName() {
        return sauceName;
    }

    public void setSauceName(String sauceName) {
        this.sauceName = sauceName;
    }

    public BigDecimal getSaucePrice() {
        return saucePrice;
    }

    public void setSaucePrice(BigDecimal saucePrice) {
        this.saucePrice = saucePrice;
    }
}
