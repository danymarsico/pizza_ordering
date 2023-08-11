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
import java.util.ArrayList;

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
    public ArrayList<Size> getAllSizes() {
        ArrayList<Size> sizesList = new ArrayList<>();

        String sql = "SELECT * FROM size;\n";

        try{
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);

            while (rowSet.next()){
                sizesList.add(mapRowToSize(rowSet));
            }

        } catch (CannotGetJdbcConnectionException ex) {
            throw new DaoException("Unable to connect to server or database", ex);
        }catch (Exception ex) {
            throw new DaoException("Something went wrong", ex);
        }


        return sizesList;
    }

    @Override
    public ArrayList<Crust> getAllCrusts() {
        ArrayList<Crust> crustsList = new ArrayList<>();

        String sql = "SELECT * FROM crust;\n";

        try{
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);

            while (rowSet.next()){
                crustsList.add(mapRowToCrust(rowSet));
            }

        } catch (CannotGetJdbcConnectionException ex) {
            throw new DaoException("Unable to connect to server or database", ex);
        }catch (Exception ex) {
            throw new DaoException("Something went wrong", ex);
        }


        return crustsList;
    }

    @Override
    public ArrayList<Sauce> getAllSauces() {
        ArrayList<Sauce> saucesList = new ArrayList<>();

        String sql = "SELECT * FROM sauce;\n";

        try{
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);

            while (rowSet.next()){
                saucesList.add(mapRowToSauce(rowSet));
            }

        } catch (CannotGetJdbcConnectionException ex) {
            throw new DaoException("Unable to connect to server or database", ex);
        }catch (Exception ex) {
            throw new DaoException("Something went wrong", ex);
        }


        return saucesList;
    }

    @Override
    public int createPizza() {
        return 0;
    }

    @Override
    public BigDecimal calculatePrice() {
        return null;
    }

  /*  @Override
    public int createPizza(String additionalInstructions, String sizeName, String sauceName, String crustName,int orderId, BigDecimal price, String orderStatus, int specialtyId) {
        int newPizzaId;

        return newPizzaId;
    }*/

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

    private Size mapRowToSize(SqlRowSet rs) {
        Size size = new Size();
        size.setSizeName(rs.getString("size_name"));
        size.setSizePrice(rs.getBigDecimal("size_price"));

        return size;
    }
    private Crust mapRowToCrust(SqlRowSet rs) {
        Crust crust = new Crust();
        crust.setCrustName(rs.getString("crust_name"));
        crust.setCrustPrice(rs.getBigDecimal("crust_price"));

        return crust;
    }
    private Sauce mapRowToSauce(SqlRowSet rs) {
        Sauce sauce = new Sauce();
        sauce.setSauceName(rs.getString("sauce_name"));
        sauce.setSaucePrice(rs.getBigDecimal("sauce_price"));

        return sauce;
    }
}
