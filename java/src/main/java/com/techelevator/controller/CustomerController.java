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
    private JdbcCustomerDao jdbcCustomerDao;
    @Autowired
    private JdbcUserDao jdbcUserDao;


    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Customer> listCustomer() {
        return jdbcCustomerDao.getAllCustomers();
    }

    @RequestMapping(path = "/customer-info", method = RequestMethod.POST)
    public void create(@RequestBody Customer newCustomer, Principal principal){
        try {
            String username = principal.getName();
            int newCustUserId = jdbcUserDao.findIdByUsername(username);

            jdbcCustomerDao.create(newCustomer, newCustUserId);
        }catch (Exception ex){
            System.out.println("Error in customer controller");
        }
    }

    @RequestMapping(path = "/{customerId}", method = RequestMethod.GET)
    public Customer getCustomerByCustomerId(@PathVariable int customerId){
        return jdbcCustomerDao.getCustomerById(customerId);
    }

    @RequestMapping(path = "/user/{userId}", method = RequestMethod.GET)
    public Customer getCustomerByUserId(@PathVariable int userId){
        return jdbcCustomerDao.getCustomerByUserId(userId);
    }
}