package com.techelevator.controller;

import com.techelevator.dao.CustomerDao;
import com.techelevator.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerDao customerDao;


    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Customer> listCustomer() {
        return customerDao.getAllCustomers();
    }


}