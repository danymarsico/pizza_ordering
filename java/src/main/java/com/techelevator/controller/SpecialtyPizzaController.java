package com.techelevator.controller;

import com.techelevator.dao.SpecialtyPizzaDao;
import com.techelevator.model.SpecialtyPizza;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpecialtyPizzaController {
    private final SpecialtyPizzaDao specialtyPizzaDao;

    public SpecialtyPizzaController(SpecialtyPizzaDao specialtyPizzaDao) {
        this.specialtyPizzaDao = specialtyPizzaDao;
    }

    @RequestMapping(path="/")
    public String[] getPizzaDetails(int id) {
        String pizzaName = specialtyPizzaDao.getPizzaDetails(id)
    }

}
