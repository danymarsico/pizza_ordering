package com.techelevator.dao;

import com.techelevator.model.SpecialtyPizza;
import com.techelevator.model.Toppings;

import java.util.ArrayList;
import java.util.List;

public interface SpecialtyPizzaDao {

    ArrayList<String> getPizzas();

    SpecialtyPizza getSpecialtyPizzaById(int id);

    SpecialtyPizza addSpecialtyPizza(SpecialtyPizza pizza);

   Toppings addSpecialtyIngredients(List<Toppings> newToppings);

}
