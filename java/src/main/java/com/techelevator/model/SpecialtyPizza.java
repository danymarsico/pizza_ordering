package com.techelevator.model;

public class SpecialtyPizza {

    private String pizzaName = "";

    private String pizzaDesc = "";

    private double pizzaPrice = 0.00;

    //TODO: add ingredients model to populate ingredients list also in the SpecialtyPizza model

    public SpecialtyPizza(String pizzaName, String pizzaDesc, double pizzaPrice) {
        this.pizzaName = pizzaName;
        this.pizzaDesc = pizzaDesc;
        this.pizzaPrice = pizzaPrice;
    };

    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public String getPizzaDesc() {
        return pizzaDesc;
    }

    public void setPizzaDesc(String pizzaDesc) {
        this.pizzaDesc = pizzaDesc;
    }

    public double getPizzaPrice() {
        return pizzaPrice;
    }

    public void setPizzaPrice(double pizzaPrice) {
        this.pizzaPrice = pizzaPrice;
    }

    //TODO: add a toString method for JSON
}
