package com.marky99.ecommerce.dao;

import com.marky99.ecommerce.entity.CountryPhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "countryPhoneNumber", path = "country-phone-numbers")
@CrossOrigin(origins="http://localhost:4200")
public interface CountryPhoneNumberRepository extends JpaRepository<CountryPhoneNumber, Integer> {
}
