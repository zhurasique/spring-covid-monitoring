package com.covid.data.controller;

import com.covid.data.domain.Data;
import com.covid.data.repo.DataRepo;
import com.covid.data.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @PostMapping
    public ResponseEntity<?> create() {
        return dataService.save();
    }
}
