package com.techelevator.dao;

import com.techelevator.model.Customer;
import com.techelevator.model.Customer;
import com.techelevator.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.security.Principal;

//TODO: GET ACTUAL SQL QUERIES - DOUBLE CHECK IN PGADMIN

@Component
public class JdbcCustomerDao implements CustomerDao {

    private final JdbcTemplate jdbcTemplate;
    private UserDao userDao;



    public JdbcCustomerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Customer create(String first_name, String last_name, String street_address, String city, String phone_number, int user_id) {
        Customer newCustomer = null;


        String sql = "INSERT INTO customer (first_name, last_name, street_address, city, phone_number, user_id) \n" +
                "VALUES (?,?,?,?,?,?)RETURNING customer_id;";
        try {
            int newCustomerId = jdbcTemplate.queryForObject(sql, int.class, newCustomer.getFirst_name().toLowerCase(),newCustomer.getLast_name().toLowerCase(), newCustomer.getStreet_address().toLowerCase(), newCustomer.getCity().toLowerCase(), newCustomer.getPhone_number());
            newCustomer = getCustomerById(newCustomerId);

            //TODO do we need this code? referencing the tenmo app jdbcUserDao
//            if(newCustomer != null){
//                sql = "";
//                jdbcTemplate.update(sql, newCustomerId);
//            }

        }catch (Exception ex){
            System.out.println("Something Went Wrong");
        }
        return newCustomer;
    }

    @Override
    public Customer update(String first_name, String last_name, String street_address, String city, String phone_number) {
        return null;
    }

    @Override
    public Customer getCustomerById(int customerId) {

        String sql = "SELECT first_name, last_name, street_address, city, phone_number, user_id\n" +
                "FROM customer\n" +
                "WHERE customer_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, customerId);
        if (results.next()) {
            return mapRowToCustomer(results);
        } else {
            return null;
        }
    }

    @Override
    public Customer getCustomerByName(String first_name, String last_name) {
        String sql = "";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, first_name, last_name);
        if (results.next()) {
            return mapRowToCustomer(results);
        } else {
            return null;
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM customer;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Customer customer = mapRowToCustomer(results);
            customers.add(customer);
        }
        return customers;
    }

    private Customer mapRowToCustomer(SqlRowSet rs) {
        Customer customer = new Customer();
        customer.setCustomer_id(rs.getInt("customer_id"));
        customer.setFirst_name(rs.getString("first_name"));
        customer.setLast_name(rs.getString("last_name"));
        customer.setStreet_address(rs.getString("street_address"));
        customer.setCity(rs.getString("city"));
        customer.setPhone_number(rs.getString("phone_number"));
        return customer;
    }
}

