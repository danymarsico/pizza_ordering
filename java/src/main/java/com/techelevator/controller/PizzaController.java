package com.techelevator.controller;

import com.techelevator.dao.JdbcPizzaDao;
import com.techelevator.dao.PizzaDao;
import com.techelevator.model.Crust;
import com.techelevator.model.Pizza;
import com.techelevator.model.Sauce;
import com.techelevator.model.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/pizza-order")
@CrossOrigin
public class PizzaController {
    @Autowired
    private JdbcPizzaDao jdbcPizzaDao;

    @RequestMapping(path = "/{pizzaId}", method = RequestMethod.GET)
    public Pizza getPizzaById(@PathVariable int pizzaId){
        return jdbcPizzaDao.getPizzaById(pizzaId);
    }

    @RequestMapping(path = "/sizes", method = RequestMethod.GET)
    public ArrayList<Size> getSizes(){
        return jdbcPizzaDao.getAllSizes();
    }
    @RequestMapping(path = "/crusts", method = RequestMethod.GET)
    public ArrayList<Crust> getCrusts(){
        return jdbcPizzaDao.getAllCrusts();
    }

    @RequestMapping(path = "/sauces", method = RequestMethod.GET)
    public ArrayList<Sauce> getSauces(){
        return jdbcPizzaDao.getAllSauces();
    }
}
