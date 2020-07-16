package com.covid.data.service;

import com.covid.data.domain.Data;
import com.covid.data.repo.DataRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class DataService {
    private final DataRepo dataRepo;

    public DataService(DataRepo dataRepo) {
        this.dataRepo = dataRepo;
    }

    public List<Data> getAll(){
        return dataRepo.findAll();
    }

    public Data getDataByCountry(String country){
        return dataRepo.findByCountry(country);
    }

    public Optional<Data> getDataById(long id){
        return dataRepo.findById(id);
    }

    public Data update(@PathVariable("id") Data dataFromDb, @RequestBody Data data){
        BeanUtils.copyProperties(data, dataFromDb, "id");
        return updateData(dataFromDb);
    }

    public Data updateData(@RequestBody Data data){
        return dataRepo.save(data);
    }

    public ResponseEntity<?> save(String country, int cases, int deaths, int recovered){
        Data data = new Data();
        data.setCountry(country);
        data.setCases(cases);
        data.setDeaths(deaths);
        data.setRecovered(recovered);

        dataRepo.save(data);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
