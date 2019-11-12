package com.example.smartmeter;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import com.example.smartmeter.domain.SmartmeterRead;
import com.example.smartmeter.repository.SmartmeterRepository;
import com.example.smartmeter.rest.SmartmeterService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@ContextConfiguration(classes={SmartmeterService.class})
@WebMvcTest
public class SmartmeterServiceTest {

    @MockBean
    private SmartmeterRepository smartmeterRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSmartMeterReadingFound() throws Exception {
        String accountNumber = "577856";
        String gasId = "1231";
        String elecId = "452352";
        String elecSmartRead = "34124";
        String gasSmartRead = "666777";

        SmartmeterRead reading1 = new SmartmeterRead();
        reading1.setAccountNumber(accountNumber);
        reading1.setElecId(elecId);
        reading1.setGasId(gasId);
        reading1.setElecSmartRead(elecSmartRead);
        reading1.setGasSmartRead(gasSmartRead);

        List<SmartmeterRead> readings = Arrays.asList(reading1);
        when(smartmeterRepository.findByAccountNumber(accountNumber)).thenReturn(readings);

        this.mockMvc.perform(get("/api/smart/reads/" + accountNumber)).
                andDo(print()).
                andExpect(status().isOk()).
                andExpect(content().json("[{\"Gas read\":\"666777\",\"Electricity read\":\"34124\"}]"));

    }
}