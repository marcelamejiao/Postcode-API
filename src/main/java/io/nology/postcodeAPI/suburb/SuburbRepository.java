package io.nology.postcodeAPI.suburb;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SuburbRepository extends JpaRepository<Suburb, Long> {

    List<Suburb> findByPostcode(String postcode);
}
