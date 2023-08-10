package com.techelevator.dao;

import com.techelevator.dao.Exception.DaoException;
import com.techelevator.model.SpecialtyPizza;
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
            while(rowSet.next()){
                pizzaList.add(rowSet.getString("pizza_name"));
            }
        } catch (CannotGetJdbcConnectionException ex){
            throw new DaoException("Unable to connect to server or database", ex);
        } catch (DataIntegrityViolationException ex){
            throw new DataIntegrityViolationException("Data Integrity Violation",ex);
        } catch (Exception ex) {
            throw new DaoException("Something went wrong",ex);
        }

        return pizzaList;
    }


    @Override
    public SpecialtyPizza getSpecialtyPizzaById(int id) {
        SpecialtyPizza newSpecialtyPizza = null;
        String sql = "SELECT * FROM specialty_pizza\n" +
                "WHERE specialty_id =?;";
        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, id);

            if (rowSet.next()) {
                newSpecialtyPizza = mapRowToSpecialtyPizza(rowSet);
            }

        } catch(Exception ex) {
            System.out.println("Something went wrong in Specialty Pizza Dao");
        }
        return newSpecialtyPizza;
    }

        private SpecialtyPizza mapRowToSpecialtyPizza(SqlRowSet rs) {
            SpecialtyPizza specialtyPizza = new SpecialtyPizza();
            specialtyPizza.setSpecialtyPizzaId(rs.getInt("specialty_id"));
            specialtyPizza.setPizzaDesc(rs.getString("pizza_desc"));
            specialtyPizza.setPizzaName(rs.getString("pizza_name"));
            return specialtyPizza;
        }
}
