package com.techelevator.controller;

import com.techelevator.dao.JdbcToppingsDao;
import com.techelevator.model.Toppings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/toppings")
@CrossOrigin
public class ToppingsController {

    @Autowired
    private JdbcToppingsDao jdbcToppingsDao;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Toppings> listToppings(){
        return jdbcToppingsDao.getAllToppings();
    }
}
//todo delete this note