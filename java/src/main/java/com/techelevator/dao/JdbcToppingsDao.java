package com.techelevator.dao;

import com.techelevator.model.Toppings;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcToppingsDao implements ToppingsDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcToppingsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //TODO: Which of these do we need to have fully wired for the presentation?

    @Override
    public List<Toppings> getAllToppings() {
        List<Toppings> allToppings = new ArrayList<>();

        String sql = "SELECT * FROM topping;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Toppings topping = mapRowToToppings(results);
            allToppings.add(topping);
        }

        return allToppings;
    }

    @Override
    public String getToppingById(int id) {
        return null;
    }

    @Override
    public int getToppingIdByName(String toppingName) {
        return 0;
    }

    @Override
    public List<Toppings> getAllToppingsPremium() {
        return null;
    }

    @Override
    public List<Toppings> getAllToppingsStandard() {
        return null;
    }

    @Override
    public Toppings updatePriceById(int id) {
        return null;
    }

    @Override
    public Toppings updateNameById(int id) {
        return null;
    }

    @Override
    public Toppings updatePremiumById(int id) {
        return null;
    }

    @Override
    public Toppings addTopping(String toppingName, boolean isPremium) {
        return null;
    }

    private Toppings mapRowToToppings(SqlRowSet rs) {
        Toppings toppings = new Toppings();
        toppings.setAdditionalPrice(rs.getBigDecimal(("additional_price")));
        toppings.setPremium((rs.getBoolean("is_premium")));
        toppings.setToppingName(rs.getString("topping_name"));
        return toppings;
    }
}
