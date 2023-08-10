package com.techelevator.dao;

import com.techelevator.model.Customer;

import java.util.List;

public interface CustomerDao {

    Customer create(Customer customer, int userId);

    Customer update(String firstName, String lastName, String streetAddress,
                String city, String phoneNumber);

    Customer getCustomerById(int customerId);

    Customer getCustomerByName(String firstName, String lastName);

    List<Customer> getAllCustomers();

};
