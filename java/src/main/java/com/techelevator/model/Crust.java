package com.techelevator.model;

import java.math.BigDecimal;

public class Crust {
  private  String crustName;
  private  BigDecimal crustPrice;

    public Crust(String crustName, BigDecimal crustPrice) {
        this.crustName = crustName;
        this.crustPrice = crustPrice;
    }
    public Crust() {}

    public String getCrustName() {
        return crustName;
    }

    public void setCrustName(String crustName) {
        this.crustName = crustName;
    }

    public BigDecimal getCrustPrice() {
        return crustPrice;
    }

    public void setCrustPrice(BigDecimal crustPrice) {
        this.crustPrice = crustPrice;
    }
}
