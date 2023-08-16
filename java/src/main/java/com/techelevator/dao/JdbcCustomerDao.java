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
    public Customer create(Customer customer, int userId) {
        Customer newCustomer = null;


        String sql = "INSERT INTO customer (first_name, last_name, street_address, city, phone_number, user_id) \n" +
                "VALUES (?,?,?,?,?,?)RETURNING customer_id;";
        try {
            int newCustomerId = jdbcTemplate.queryForObject(sql, int.class, customer.getFirstName().toLowerCase(),customer.getLastName().toLowerCase(), customer.getStreetAddress().toLowerCase(), customer.getCity().toLowerCase(), customer.getPhoneNumber(), userId);
            newCustomer = getCustomerById(newCustomerId);

            //TODO do we need this code? referencing the tenmo app jdbcUserDao
//            if(newCustomer != null){
//                sql = "";
//                jdbcTemplate.update(sql, newCustomerId);
//            }

        }catch (Exception ex){
            System.out.println("Error in customer jdbc dao");
        }
        return newCustomer;
    }

    @Override
    public Customer update(String firstName, String lastName, String streetAddress, String city, String phoneNumber) {
        return null;
    }

    @Override
    public Customer getCustomerById(int customerId) {
        Customer newCustomer = null;

        String sql = "SELECT customer_id, first_name, last_name, street_address, city, phone_number, user_id\n" +
                "FROM customer\n" +
                "WHERE customer_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, customerId);
            if (results.next()) {
                newCustomer = mapRowToCustomer(results);
            }
        }catch (Exception ex){
            System.out.println("something went wrong in customer dao");
        }

        return newCustomer;
    }

    @Override
    public Customer getCustomerByUserId(int userId) {

        String sql = "SELECT customer_id, first_name, last_name, street_address, city, phone_number\n" +
                "FROM customer\n" +
                "WHERE user_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        if (results.next()) {
            return mapRowToCustomer(results);
        } else {
            return null;
        }
    }

    @Override
    public Customer getCustomerByName(String firstName, String lastName) {
        String sql = "";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, firstName, lastName);
        if (results.next()) {
            return mapRowToCustomer(results);
        } else {
            return null;
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT customer_id, first_name, last_name, street_address, city, phone_number, user_id FROM customer;";
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
        customer.setFirstName(rs.getString("first_name"));
        customer.setLastName(rs.getString("last_name"));
        customer.setStreetAddress(rs.getString("street_address"));
        customer.setCity(rs.getString("city"));
        customer.setPhoneNumber(rs.getString("phone_number"));
        customer.setUserId(rs.getInt("user_id"));
        return customer;
    }
}

