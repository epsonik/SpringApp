package com.example.springapp.service;

import com.example.springapp.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class CountriesService {
    CountryRepository countryRepository;

    @Autowired
    public CountriesService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<String> calculateRoute(String origin, String destination) {
        PathBetweenNodes pathBetweenNodes = new PathBetweenNodes(countryRepository.getGraph());
        pathBetweenNodes.setSTART(origin);
        pathBetweenNodes.setEND(destination);
        LinkedList<String> visited = new LinkedList<>();
        visited.add(origin);
        pathBetweenNodes.breadthFirst(pathBetweenNodes, visited);
        return pathBetweenNodes.getFinalPath();
    }

}
