package com.covid.data.repo;

import com.covid.data.domain.Data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepo extends JpaRepository<Data, Long> {
}
