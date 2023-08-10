package com.techelevator.controller;

import com.techelevator.dao.CustomerDao;
import com.techelevator.dao.JdbcCustomerDao;
import com.techelevator.dao.JdbcUserDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/customers")
@CrossOrigin
public class CustomerController {

    @Autowired
    private JdbcCustomerDao customerDao;
    private JdbcUserDao jdbcUserDao;


    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Customer> listCustomer() {
        return customerDao.getAllCustomers();
    }

    @RequestMapping(path = "/customer-info", method = RequestMethod.POST)
    public void create(@RequestBody Customer newCustomer, Principal principal){
        //TODO Principal is returning null nullpointerexception thrown
        try {
            String username = principal.getName();
            int newCustUserId = jdbcUserDao.findIdByUsername(username);

            customerDao.create(newCustomer.getFirst_name().toLowerCase(), newCustomer.getLast_name().toLowerCase(), newCustomer.getStreet_address().toLowerCase(), newCustomer.getCity().toLowerCase(), newCustomer.getPhone_number(),newCustUserId );
        }catch (Exception ex){
            System.out.println("Cannot create customer");
        }

    }
}