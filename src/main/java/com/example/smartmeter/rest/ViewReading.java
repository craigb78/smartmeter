package com.example.smartmeter.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Response DTO
 */
public class ViewReading {
    @JsonProperty("Gas read")
    private String gasRead;

    @JsonProperty("Electricity read")
    private String electricityRead;

    public ViewReading(String gasRead, String electricityRead) {
        this.gasRead = gasRead;
        this.electricityRead = electricityRead;
    }
}
