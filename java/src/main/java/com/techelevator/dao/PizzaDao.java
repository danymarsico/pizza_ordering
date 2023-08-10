package com.techelevator.dao;

import java.math.BigDecimal;

public interface PizzaDao {
    int getPizzaId();
    String getAdditionalInstructions();
    Size getSizeSelected(String name);
    String getCrustSelected();
    String getSauceSelected();
    int getOrderId();
    int getSpecialtyId();
    String getOrderStatus();
    BigDecimal calculatePrice();
}
