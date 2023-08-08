package com.techelevator.model;


//TODO CHECK ON ZIP CODE (ADD NEW TABLE ROW?)

public class Customer {

    private int customer_id;
    private String first_name;
    private String last_name;
    private String street_address;
    private String city;
    private String phone_number;

    public Customer() {

    }

    public Customer(int customer_id, String first_name, String last_name, String street_address, String city, String phone_number) {
        this.customer_id = customer_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.street_address = street_address;
        this.city = city;
        this.phone_number = phone_number;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getStreet_address() {
        return street_address;
    }

    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customer_id=" + customer_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", street_address='" + street_address + '\'' +
                ", city='" + city + '\'' +
                ", phone_number='" + phone_number + '\'' +
                '}';
    }
}