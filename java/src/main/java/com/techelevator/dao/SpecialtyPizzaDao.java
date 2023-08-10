package com.techelevator.dao;

import com.techelevator.model.SpecialtyPizza;

import java.util.ArrayList;

public interface SpecialtyPizzaDao {

    ArrayList<String> getPizzas();

    SpecialtyPizza getSpecialtyPizzaById(int id);

}
