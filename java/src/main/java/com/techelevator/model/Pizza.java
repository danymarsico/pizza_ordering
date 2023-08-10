package com.techelevator.model;

import java.math.BigDecimal;

public class Pizza {
    private int pizzaId;
    private String additionalInstructions;
    private String sizeSelected;
    private String crustSelected;
    private String sauceSelected;
    private int orderId;
    private int specialtyId;
    private String orderStatus;
    private BigDecimal price;

    //Constructor

    public Pizza(int pizzaId, String additionalInstructions, String sizeSelected, String crustSelected, String sauceSelected, int orderId, int specialtyId, String orderStatus, BigDecimal price) {
        this.pizzaId = pizzaId;
        this.additionalInstructions = additionalInstructions;
        this.sizeSelected = sizeSelected;
        this.crustSelected = crustSelected;
        this.sauceSelected = sauceSelected;
        this.orderId = orderId;
        this.specialtyId = specialtyId;
        this.orderStatus = orderStatus;
        this.price = price;
    }

    //Getters and Setters

    public int getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(int pizzaId) {
        this.pizzaId = pizzaId;
    }

    public String getAdditionalInstructions() {
        return additionalInstructions;
    }

    public void setAdditionalInstructions(String additionalInstructions) {
        this.additionalInstructions = additionalInstructions;
    }

    public String getSizeSelected() {
        return sizeSelected;
    }

    public void setSizeSelected(String sizeSelected) {
        this.sizeSelected = sizeSelected;
    }

    public String getCrustSelected() {
        return crustSelected;
    }

    public void setCrustSelected(String crustSelected) {
        this.crustSelected = crustSelected;
    }

    public String getSauceSelected() {
        return sauceSelected;
    }

    public void setSauceSelected(String sauceSelected) {
        this.sauceSelected = sauceSelected;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(int specialtyId) {
        this.specialtyId = specialtyId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    //toString method

    @Override
    public String toString() {
        return "Pizza{" +
                "pizzaId=" + pizzaId +
                ", additionalInstructions='" + additionalInstructions + '\'' +
                ", sizeSelected='" + sizeSelected + '\'' +
                ", crustSelected='" + crustSelected + '\'' +
                ", sauceSelected='" + sauceSelected + '\'' +
                ", orderId=" + orderId +
                ", specialtyId=" + specialtyId +
                ", orderStatus='" + orderStatus + '\'' +
                ", price=" + price +
                '}';
    }
}
