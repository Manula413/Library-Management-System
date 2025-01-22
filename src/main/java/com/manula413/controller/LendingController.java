package com.manula413.controller;

import com.manula413.model.Lending;
import com.manula413.repository.LendingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lendings")
public class LendingController {

    @Autowired
    private LendingRepository lendingRepository;

    // Get all lendings
    @GetMapping
    public List<Lending> getAllLendings() {
        return lendingRepository.findAll();
    }

    // Get lending by ID
    @GetMapping("/{id}")
    public ResponseEntity<Lending> getLendingById(@PathVariable Long id) {
        Optional<Lending> lending = lendingRepository.findById(id);
        if (lending.isPresent()) {
            return new ResponseEntity<>(lending.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Add a new lending
    @PostMapping
    public ResponseEntity<Lending> addLending(@RequestBody Lending lending) {
        Lending savedLending = lendingRepository.save(lending);
        return new ResponseEntity<>(savedLending, HttpStatus.CREATED);
    }

    // Update an existing lending
    @PutMapping("/{id}")
    public ResponseEntity<Lending> updateLending(@PathVariable Long id, @RequestBody Lending lending) {
        if (lendingRepository.existsById(id)) {
            lending.setId(id);
            Lending updatedLending = lendingRepository.save(lending);
            return new ResponseEntity<>(updatedLending, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a lending
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLending(@PathVariable Long id) {
        if (lendingRepository.existsById(id)) {
            lendingRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

