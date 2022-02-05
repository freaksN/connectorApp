package com.demiconconnectorapp.controllers;

import com.demiconconnectorapp.models.RandomUser;
import com.demiconconnectorapp.repositories.RandomUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.demiconconnectorapp.utils.FormatUtils.formatJsonResponse;
import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newHashMap;
import static java.util.Objects.requireNonNull;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ConnectorController {

    @Autowired
    private RandomUserRepository randomUserRepository;

    public ConnectorController(RandomUserRepository randomUserRepository) {
        this.randomUserRepository = requireNonNull(randomUserRepository);
    }

    /**
     * list the response as requested
     *
     * @return
     */
    @GetMapping(value = "/list", produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> list() {
        List<RandomUser> users = newArrayList(randomUserRepository.findAll(Sort.by(Sort.Direction.ASC, "location.country")));

        List<Map<String, Object>> items = newArrayList();
        Map<String, Object> result = newHashMap();
        formatJsonResponse(users, items);

        result.put("countries", items);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    /**
     * get all distinct countries
     *
     * @return
     */
    @GetMapping(value = "/countries", produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> getCountries() {
        List<RandomUser> users = newArrayList(randomUserRepository.findAll());
        Set<String> countries = users.stream().map(item -> item.getLocation().getCountry()).collect(Collectors.toSet());

        return ResponseEntity.ok(countries);
    }

    /**
     * get all available data based on the passed country
     *
     * @param country
     * @return
     */
    @GetMapping(value = "/users/{country}", produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> getUsersForSelectedCountry(@PathVariable String country) {
        List<RandomUser> users = newArrayList(randomUserRepository.findByLocation_Country(country));

        return ResponseEntity.ok(users);
    }

}
