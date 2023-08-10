package com.techelevator.dao;

import com.techelevator.model.Crust;
import com.techelevator.model.Pizza;
import com.techelevator.model.Sauce;
import com.techelevator.model.Size;

import java.math.BigDecimal;

public interface PizzaDao {
    Pizza getPizzaById(int pizzaId);
    Size getAllSizes();
//    Size getSizeSelected(String sizeName);
    Crust getAllCrusts();
//    Crust getCrustSelected(String crustName);
    Sauce getAllSauces();
//    Sauce getSauceSelected(String sauceName);
    BigDecimal calculatePrice();
}
