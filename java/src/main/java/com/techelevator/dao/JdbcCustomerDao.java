package com.techelevator.dao;

import com.techelevator.model.Customer;
import com.techelevator.model.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//TODO: GET ACTUAL SQL QUERIES - DOUBLE CHECK IN PGADMIN

@Component
public class JdbcCustomerDao implements CustomerDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcCustomerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Customer create(String first_name, String last_name, String street_address, String city, String phone_number) {
        Customer customer = null;
        String sql = "";

        try {

        }catch (Exception ex){
            System.out.println("Something Went Wrong");
        }
        return customer;
    }

    @Override
    public Customer update(String first_name, String last_name, String street_address, String city, String phone_number) {
        return null;
    }

    @Override
    public Customer getCustomerById(int customerId) {
        String sql = "";
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

