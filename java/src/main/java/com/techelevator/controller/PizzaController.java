package com.techelevator.controller;

import com.techelevator.dao.PizzaDao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PizzaController {
    private final PizzaDao pizzaDao;

    private final path = "/pizza-order";

    public PizzaController(PizzaDao pizzaDao) {
        this.pizzaDao = pizzaDao;
    }

    @RequestMapping(path = path + "/{id}")
}
