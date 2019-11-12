package com.example.smartmeter.rest;

import com.example.smartmeter.domain.SmartmeterRead;
import com.example.smartmeter.repository.SmartmeterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("api/smart")
public class SmartmeterService {

    @Autowired
    private SmartmeterRepository smartmeterRepository;


    @GetMapping(value = "reads/{accountNumber}", produces="application/json")
    public ResponseEntity read(@PathVariable("accountNumber") String accountNumber){
        List<SmartmeterRead> reads = smartmeterRepository.findByAccountNumber(accountNumber);
        if (reads != null && !reads.isEmpty()) {
            List<ViewReading> readings = reads.stream().map(reading ->
                    new ViewReading(reading.getGasSmartRead(), reading.getElecSmartRead())).
                    collect(Collectors.toList());
            return ResponseEntity.ok(readings);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Smart reading not found");
        }
    }

}
