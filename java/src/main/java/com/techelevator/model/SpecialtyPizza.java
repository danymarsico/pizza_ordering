package com.techelevator.model;

public class SpecialtyPizza {

    private String pizzaName = "";

    private String pizzaDesc = "";

    public SpecialtyPizza() {};

    public SpecialtyPizza(String pizzaName, String pizzaDesc) {
        this.pizzaName = pizzaName;
        this.pizzaDesc = pizzaDesc;
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


    @Override
    public String toString() {
        return "SpecialtyPizza{" +
                "pizzaName='" + pizzaName + '\'' +
                ", pizzaDesc='" + pizzaDesc + '\'' +
                '}';
    }
}
