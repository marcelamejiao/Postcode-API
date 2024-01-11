package io.nology.postcodeAPI.suburb;

import io.nology.postcodeAPI.exceptions.NotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/suburbs")
public class SuburbController {

    @Autowired
    private SuburbService suburbService;
    @GetMapping
    public ResponseEntity<List<Suburb>> getAll() {
        List<Suburb> allSuburbs = this.suburbService.getAll();
        return new ResponseEntity<>(allSuburbs, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Suburb> createSuburb(@Valid @RequestBody SuburbCreateDTO data) {
        Suburb newSuburb = this.suburbService.createSuburb(data);
        return new ResponseEntity<Suburb>(newSuburb, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Suburb> deleteById(@PathVariable Long id) {
        boolean deleted = this.suburbService.deleteById(id);

        if(deleted == true) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }

        throw new NotFoundException(String
                .format("Suburb with id: %d does not exist, could not delete", id));
    }

    @GetMapping("/by-postcode")
    @ResponseBody
    public ResponseEntity<List<Suburb>> getAllByPostcode(@RequestParam String postcode) {
        List<Suburb> allSuburbs = this.suburbService.getAllByPostcode(postcode);
        return new ResponseEntity<>(allSuburbs, HttpStatus.OK);
    }

    @GetMapping("/by-name")
    @ResponseBody
    public ResponseEntity<List<Suburb>> getAllByName(@RequestParam String name) {
        List<Suburb> allSuburbs = this.suburbService.getAllByName(name);
        return new ResponseEntity<>(allSuburbs, HttpStatus.OK);
    }
}
