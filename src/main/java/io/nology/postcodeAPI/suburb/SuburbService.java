package io.nology.postcodeAPI.suburb;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SuburbService {

    // dependency injection
    @Autowired
    private SuburbRepository suburbRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<Suburb> getAll() {
        return this.suburbRepository.findAll();
    }

    public Suburb createSuburb(SuburbCreateDTO data) {
        Suburb newSuburb = modelMapper.map(data, Suburb.class);
        Suburb created = this.suburbRepository.save(newSuburb);

        return created;
    }

    public List<Suburb> getAllByPostcode(String postcode) {
        return this.suburbRepository.findByPostcode(postcode);
    }

    public List<Suburb> getAllByName(String name) {
        return this.suburbRepository.findByName(name);
    }

    public boolean deleteById(Long id) {
        Optional<Suburb> foundSuburb = this.suburbRepository.findById(id);

        if(foundSuburb .isPresent()) {
            this.suburbRepository.delete(foundSuburb.get());
            return true;
        }

        return false;
    }
}
