package com.techelevator.controller;

import com.techelevator.dao.JdbcSpecialtyPizzaDao;
import com.techelevator.dao.SpecialtyPizzaDao;
import com.techelevator.model.SpecialtyPizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/admin-pizza")
@CrossOrigin
public class SpecialtyPizzaController {

    @Autowired
    private JdbcSpecialtyPizzaDao jdbcSpecialtyPizzaDao;

    @RequestMapping(path="/all", method = RequestMethod.GET)
    public ArrayList<String> getPizzas() {
        return jdbcSpecialtyPizzaDao.getPizzas();
    }

    @RequestMapping(path="/{id}", method = RequestMethod.GET)
    public SpecialtyPizza getSpecialtyPizzaById(@PathVariable int id) {
        return jdbcSpecialtyPizzaDao.getSpecialtyPizzaById(id);
    }
}
