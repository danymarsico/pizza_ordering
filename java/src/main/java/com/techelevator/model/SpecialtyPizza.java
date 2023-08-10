package com.techelevator.model;

public class SpecialtyPizza {

    private String pizzaName = "";

    private String pizzaDesc = "";

    private int specialtyPizzaId = 0;

    public SpecialtyPizza() {};

    public SpecialtyPizza(String pizzaName, String pizzaDesc, int specialtyPizzaId) {
        this.pizzaName = pizzaName;
        this.pizzaDesc = pizzaDesc;
        this.specialtyPizzaId = specialtyPizzaId;
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

    public int getSpecialtyPizzaId() {
        return specialtyPizzaId;
    }

    public void setSpecialtyPizzaId(int specialtyPizzaId) {
        this.specialtyPizzaId = specialtyPizzaId;
    }

    @Override
    public String toString() {
        return "SpecialtyPizza{" +
                "pizzaName='" + pizzaName + '\'' +
                ", pizzaDesc='" + pizzaDesc + '\'' +
                ", specialtyPizzaId=" + specialtyPizzaId +
                '}';
    }
}
