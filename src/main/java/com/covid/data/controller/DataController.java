package com.covid.data.controller;

import com.covid.data.domain.Data;
import com.covid.data.repo.DataRepo;
import com.covid.data.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class DataController {
    private final DataService dataService;

    @Autowired
    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping
    public List<Data> getAll(){
        return dataService.getAll();
    }

    @GetMapping("/country")
    public Data getDataByCountry(String country){
        return dataService.getDataByCountry(country);
    }

    @GetMapping("/id")
    public Optional<Data> getDataById(long id){
        return dataService.getDataById(id);
    }
}
