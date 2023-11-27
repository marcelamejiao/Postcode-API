package io.nology.postcodeAPI.suburb;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class SuburbService {

    // dependency injection
    @Autowired
    private SuburbRepository suburbRepository;

    public List<Suburb> getAll() {
        return this.suburbRepository.findAll();
    }
}
