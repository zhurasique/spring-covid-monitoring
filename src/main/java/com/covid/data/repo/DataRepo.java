package com.covid.data.repo;

import com.covid.data.domain.Data;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DataRepo extends JpaRepository<Data, Long> {
    Data findByCountry(String country);
}
