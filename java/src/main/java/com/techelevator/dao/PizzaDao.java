package com.techelevator.dao;

import com.techelevator.model.Crust;
import com.techelevator.model.Pizza;
import com.techelevator.model.Sauce;
import com.techelevator.model.Size;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;

public interface PizzaDao {
    Pizza getPizzaById(int pizzaId);
     ArrayList<Size> getAllSizes();
    ArrayList<Crust> getAllCrusts();
    ArrayList<Sauce> getAllSauces();
    int createPizza();
    BigDecimal calculatePrice();
}
