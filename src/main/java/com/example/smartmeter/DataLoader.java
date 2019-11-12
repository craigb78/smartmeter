package com.example.smartmeter;

import com.example.smartmeter.domain.SmartmeterRead;
import com.example.smartmeter.repository.SmartmeterRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

/**
 * Initial data load.
 */
@Component
public class DataLoader {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private ClassPathResource resource = new ClassPathResource("/data.json");

    @Autowired
    private SmartmeterRepository smartmeterRepository;

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = resource.getInputStream();
            List<SmartmeterRead> smartmeterReads = mapper.readValue(inputStream, new TypeReference<List<SmartmeterRead>>() {});
            smartmeterRepository.saveAll(smartmeterReads);
        } catch (Exception e) {
            logger.error("error loading initial data", e);
        }
    }

}