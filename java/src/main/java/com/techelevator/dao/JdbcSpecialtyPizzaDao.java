package com.techelevator.dao;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class JdbcSpecialtyPizzaDao implements SpecialtyPizzaDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcSpecialtyPizzaDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public ArrayList<String> getPizzas() {
        ArrayList<String> pizzaList = new ArrayList<>();

        String sql="SELECT PIZZA_NAME FROM SPECIALTY_PIZZA";

        try{
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
            if(rowSet.next()){
                pizzaList.add(rowSet.getString("pizza_name"));
            }
        } catch (CannotGetJdbcConnectionException ex){
            throw new DaoException("Unable to connect to server or database", ex);
        } catch (DataIntegrityViolationException ex){
            throw new DataIntegrityViolationException("Data Integrity Violation",ex);
        } catch (Exception ex) {
            throw new DaoExpection("Something went wrong",ex);
        }

        return pizzaList;
    }

    @Override
    public String[] getPizzaDetails(int id) {
        return new String[0];
    }

    @Override
    public void createPizza(String pizzaName, String pizzaDesc, double pizzaPrice) {

    }
}
