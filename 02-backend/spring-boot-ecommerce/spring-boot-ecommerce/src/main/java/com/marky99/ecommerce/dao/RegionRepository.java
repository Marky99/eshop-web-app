package com.marky99.ecommerce.dao;

import com.marky99.ecommerce.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("http://localhost:4200")
public interface RegionRepository extends JpaRepository<Region, Integer> {
    List<Region> findByCountryCode(@Param("code") String code);
}
