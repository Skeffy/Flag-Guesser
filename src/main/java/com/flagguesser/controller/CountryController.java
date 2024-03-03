package com.flagguesser.controller;

import com.flagguesser.dao.CountryDao;
import com.flagguesser.model.Country;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping(path = "/country")
public class CountryController {

    private CountryDao countryDao;

    public CountryController(CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    @GetMapping
    public Country get() {
        Random random = new Random();
        int id = random.nextInt(1,196);
        return countryDao.getCountry(id);
    }
}
