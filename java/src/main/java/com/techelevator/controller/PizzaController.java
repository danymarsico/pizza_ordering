package com.techelevator.controller;

import com.techelevator.dao.JdbcPizzaDao;
import com.techelevator.dao.PizzaDao;
import com.techelevator.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

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
}
