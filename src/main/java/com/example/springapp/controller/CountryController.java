package com.example.springapp.controller;

import com.example.springapp.service.CountriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CountryController {
    CountriesService countriesService;

    @Autowired
    public CountryController(CountriesService countriesService) {
        this.countriesService = countriesService;
    }

    @GetMapping("/routing/{origin}/{destination}")
    public ResponseEntity<Path> getRouting(@PathVariable("origin") String origin, @PathVariable("destination") String destination) {
        List<String> listOfCountries = countriesService.calculateRoute(origin, destination);
        if (listOfCountries.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new Path(listOfCountries), HttpStatus.OK);
    }

    public class Path {
        private List<String> route;

        public Path(List<String> route) {
            this.route = route;
        }

        public List<String> getRoute() {
            return route;
        }
    }

}
