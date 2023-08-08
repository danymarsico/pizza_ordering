package com.techelevator.dao;

import com.techelevator.model.Customer;

import java.util.List;

public interface CustomerDao {

    Customer create(String first_name, String last_name, String street_address,
                   String city, String phone_number);

    Customer update(String first_name, String last_name, String street_address,
                String city, String phone_number);

    Customer getCustomerById(int customerId);

    Customer getCustomerByName(String first_name, String last_name);

    List<Customer> getAllCustomers();

};
