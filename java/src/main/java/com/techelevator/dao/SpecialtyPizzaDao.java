package com.techelevator.dao;

public interface SpecialtyPizzaDao {
    String[] getPizzaDetails(int id);

    void createPizza(String pizzaName, String pizzaDesc, double pizzaPrice);
}
