package com.example.demo.Repository;

import com.example.demo.Model.Housing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HousingRepository extends JpaRepository<Housing , Integer> {

//    Average sale price of the house overall
    @Query(value = "select avg(sale_price) from housing_data", nativeQuery = true)
    Double getAvgPriceOverall();

//    Max sale price
//    @Query(value = "select max(sale_price) from housing_data" , nativeQuery = true)
//    int getMaxPrice();

//    subquery and return all data not a only number
    @Query(value = "select * from housing_data where sale_price = (select max(sale_price) from housing_data)" , nativeQuery = true)
    List<Housing> getMaxPrice();

//    Min sale price
    @Query(value = "select min(sale_price) from housing_data" , nativeQuery = true)
    int getMinPrice();

//    Get avg price by location
    @Query(value = "select avg(sale_price) from housing_data where location = ?",nativeQuery = true)
    Double getAvgByLocation(String location);

//    Average sale price of the house per location
    @Query(value = "select location , avg(sale_price) from housing_data group by location", nativeQuery = true)
    List<Object[]> getAvgHouPerLoc();

}
