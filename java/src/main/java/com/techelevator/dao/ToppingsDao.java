package com.techelevator.dao;

import com.techelevator.model.Toppings;

import java.util.ArrayList;
import java.util.List;

public interface ToppingsDao {

    List<Toppings> getAllToppings();
    String getToppingById(int id);
    int getToppingIdByName(String toppingName);
    List<Toppings> getAllToppingsPremium();
    List<Toppings> getAllToppingsStandard();

    Toppings updatePriceById(int id);
    Toppings updateNameById(int id);
    Toppings updatePremiumById(int id);

    //Can add additional functionality, if needed

    Toppings addTopping(String toppingName, boolean isPremium);

}
