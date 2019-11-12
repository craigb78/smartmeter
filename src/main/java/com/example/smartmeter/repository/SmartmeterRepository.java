package com.example.smartmeter.repository;

import com.example.smartmeter.domain.SmartmeterRead;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SmartmeterRepository extends JpaRepository<SmartmeterRead, Long> {
    List<SmartmeterRead> findByAccountNumber(String accountNumber);
}
