package com.example.demo.Service;

import com.example.demo.Model.Housing;
import com.example.demo.Repository.HousingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Objects;

@Service
public class HousingService {

    @Autowired
    private HousingRepository housingRepository;

    public ResponseEntity<String> saveData(@RequestBody List<Housing> data) {
        try {
            housingRepository.saveAll(data);
            return ResponseEntity.status(HttpStatus.CREATED).body("Data saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }

    public double getAvgPriceOverall() {
        return housingRepository.getAvgPriceOverall();
    }

    public List<Housing> getMaxPrice() {
        return housingRepository.getMaxPrice();
    }

    public int getMinPrice() {
        return housingRepository.getMinPrice();
    }

    public Double getAvgByLocation(String location) {
        return housingRepository.getAvgByLocation(location);
    }

    public List<Object[]> getAvgHouPerLoc() {
        return housingRepository.getAvgHouPerLoc();
    }

}
