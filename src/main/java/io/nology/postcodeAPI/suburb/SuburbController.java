package io.nology.postcodeAPI.suburb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/suburbs")
public class SuburbController {

    @Autowired
    private SuburbService suburbService;
    @GetMapping
    public ResponseEntity<List<Suburb>> getAll() {
//        List<Suburb> allSuburbs = this.suburbService.getAll();
//        return new ResponseEntity<>(allSuburbs, HttpStatus.OK);
        return new ResponseEntity<>(new ArrayList(), HttpStatus.OK);
    }
}
