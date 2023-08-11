package com.techelevator.dao;

import com.techelevator.dao.Exception.DaoException;
import com.techelevator.model.Crust;
import com.techelevator.model.Pizza;
import com.techelevator.model.Sauce;
import com.techelevator.model.Size;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class JdbcPizzaDao implements PizzaDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPizzaDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Pizza getPizzaById(int pizzaId) {
        Pizza selectedPizza = null;

        String sql = "SELECT * FROM pizza\n" +
                "WHERE pizza_id = ?;\n";
        try{
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, pizzaId);
            if(rowSet.next()){
                selectedPizza = mapRowToPizza(rowSet);
            }
        } catch (CannotGetJdbcConnectionException ex) {
            throw new DaoException("Unable to connect to server or database", ex);
        }catch (Exception ex) {
            throw new DaoException("Something went wrong", ex);
        }

        return selectedPizza;
    }

    @Override
    public Size getAllSizes() {
        return null;
    }

    @Override
    public Crust getAllCrusts() {
        return null;
    }

    @Override
    public Sauce getAllSauces() {
        return null;
    }

    @Override
    public BigDecimal calculatePrice() {
        return null;
    }

    private Pizza mapRowToPizza(SqlRowSet rs) {
        Pizza pizza = new Pizza();
        pizza.setPizzaId(rs.getInt("pizza_id"));
        pizza.setAdditionalInstructions(rs.getString("additional_instructions"));
        pizza.setSizeSelected(rs.getString("size_name"));
        pizza.setCrustSelected(rs.getString("crust_name"));
        pizza.setSauceSelected(rs.getString("sauce_name"));
        pizza.setOrderId(rs.getInt("order_id"));
        pizza.setSpecialtyId(rs.getInt("specialty_id"));
        pizza.setOrderStatus(rs.getString("order_id"));
        pizza.setPrice(rs.getBigDecimal("price"));

        return pizza;
    }

    //test comment for Marina issue
}
