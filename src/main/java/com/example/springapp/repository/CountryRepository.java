package com.example.springapp.repository;

import com.example.springapp.Country;
import com.example.springapp.service.Graph;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.*;

@Repository
public class CountryRepository {

    private Graph graph;

    public CountryRepository() throws IOException {
        setGraph();
    }

    private void setGraph() throws IOException {
        Resource resource = new ClassPathResource("countries.json");
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        List<Country> countryList = objectMapper.readValue(
                resource.getFile(),
                new TypeReference<>() {
                });
        Graph graph = new Graph();
        for (Country country : countryList) {
            if (country.getBorders().length > 0) {
                for (String border : country.getBorders()) {
                    graph.addEdge(country.getCca3(), border);
                }
            }

        }
        this.graph = graph;
    }

    public Graph getGraph() {
        return graph;
    }
}
