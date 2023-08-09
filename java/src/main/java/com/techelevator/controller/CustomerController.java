package com.techelevator.controller;

import com.techelevator.dao.CustomerDao;
import com.techelevator.dao.JdbcCustomerDao;
import com.techelevator.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
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

    @RequestMapping(path = "/customer-info", method = RequestMethod.POST)
    public void create(@RequestBody Customer newCustomer, Principal principal){
        try {
            String username = principal.getName();
            Customer customer = customerDao.getCustomerById(newCustomer.getCustomer_id());
            customerDao.create(newCustomer.getFirst_name().toLowerCase(), newCustomer.getLast_name().toLowerCase(), newCustomer.getStreet_address().toLowerCase(), newCustomer.getCity().toLowerCase(), newCustomer.getPhone_number());
        }catch (Exception ex){
            System.out.println("Cannot create customer");
        }

    }
}