package com.techelevator.dao;

import java.util.ArrayList;

public interface SpecialtyPizzaDao {

    ArrayList<String> getPizzas();
    String[] getPizzaDetails(int id);

    void createPizza(String pizzaName, String pizzaDesc, double pizzaPrice);
}
