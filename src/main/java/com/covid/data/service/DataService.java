package com.covid.data.service;

import com.covid.data.domain.Data;
import com.covid.data.repo.DataRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {
    private final DataRepo dataRepo;

    public DataService(DataRepo dataRepo) {
        this.dataRepo = dataRepo;
    }

    public List<Data> getAll(){
        return dataRepo.findAll();
    }

    public ResponseEntity<?> save(){
        Data data = new Data();
        data.setCountry("Poland");
        data.setCases(40000);
        data.setDeaths(500);
        data.setRecovered(8000);

        dataRepo.save(data);
        System.out.println("Saved data");
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
