package com.example.demo.Controller;

import com.example.demo.Model.Housing;
import com.example.demo.Service.HousingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/housing")
public class HousingController {

    @Autowired
    private HousingService housingService;


    @PostMapping("/save-all")
    public ResponseEntity<String> saveData(@RequestBody List<Housing> data) {
        return housingService.saveData(data);
    }


//    @PostMapping("/save-all")
//    public ResponseEntity<String> saveData(@RequestBody List<Housing> data){
//        try{
//            housingService.saveHousingData(data);
//            return ResponseEntity.status(HttpStatus.CREATED).body("Data saved successfully");
//        }catch (Exception e){
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: "+e.getMessage());
//        }
//    }

//    http://localhost:8080/housing/avg-overall
    @GetMapping("avg-overall")
    public double getAvgPriceOverall(){
        return housingService.getAvgPriceOverall();
    }
//    http://localhost:8080/housing/max
    @GetMapping("max")
    public List<Housing> getMaxPrice(){
        return housingService.getMaxPrice();
    }

//    http://localhost:8080/housing/min
    @GetMapping("min")
    public int getMinPrice()    {
        return housingService.getMinPrice();
    }

//    http://localhost:8080/housing/avg-by-location?location=C
    @GetMapping("avg-by-location")
    public Double getAvgByLocation(@RequestParam String location){
        return housingService.getAvgByLocation(location);
    }

//    http://localhost:8080/housing/avg-house-per-location
    @GetMapping("avg-house-per-location")
    public List<Object[]> getAvgByHouPerLoc() {
        return housingService.getAvgHouPerLoc();
    }
}
