package com.techelevator.model;

import java.math.BigDecimal;

public class Size {
    private String sizeName;
    private BigDecimal sizePrice;

    public Size (String sizeName, BigDecimal sizePrice) {
        this.sizeName = sizeName;
        this.sizePrice = sizePrice;
    }
    public Size () {}

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public BigDecimal getSizePrice() {
        return sizePrice;
    }

    public void setSizePrice(BigDecimal sizePrice) {
        this.sizePrice = sizePrice;
    }
}
