package com.techelevator.controller;

import com.techelevator.dao.SpecialtyPizzaDao;
import com.techelevator.model.SpecialtyPizza;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class SpecialtyPizzaController {
    private final SpecialtyPizzaDao specialtyPizzaDao;

    public SpecialtyPizzaController(SpecialtyPizzaDao specialtyPizzaDao) {
        this.specialtyPizzaDao = specialtyPizzaDao;
    }

    @RequestMapping(path="/admin-pizza", method = RequestMethod.GET)
    public ArrayList<String> getPizzas() {

        return specialtyPizzaDao.getPizzas();
    }

}
