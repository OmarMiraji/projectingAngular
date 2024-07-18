package com.ccm.bita.student.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ccm.bita.student.Repository.TourRepository;
import com.ccm.bita.student.model.TourModel;

@RestController
@RequestMapping("/api/v1/tour")
public class TourController {

   
    private TourRepository tourRepository;

    @GetMapping("/api/")
    public ResponseEntity<List<TourModel>> getAllTours() {
        List<TourModel> tours = tourRepository.findAll();
        return new ResponseEntity<>(tours, HttpStatus.OK);
    }

    @PostMapping("api/")
    public ResponseEntity<TourModel> addTour(@RequestBody TourModel tour) {
        TourModel savedTour = tourRepository.save(tour);
        return new ResponseEntity<>(savedTour, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTourById(@PathVariable Long id) {
        Optional<TourModel> tour = tourRepository.findById(id);
        if (tour.isPresent()) {
            return new ResponseEntity<>(tour.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Tour not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTour(@PathVariable Long id) {
        if (tourRepository.existsById(id)) {
            tourRepository.deleteById(id);
            return new ResponseEntity<>("Tour deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Tour not found", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTour(@PathVariable Long id, @RequestBody TourModel tourDetails) {
        Optional<TourModel> optionalTour = tourRepository.findById(id);
        if (optionalTour.isPresent()) {
            TourModel existingTour = optionalTour.get();
            existingTour.setUsername(tourDetails.getUsername());
            existingTour.setPassword(tourDetails.getPassword());
            TourModel updatedTour = tourRepository.save(existingTour);
            return new ResponseEntity<>(updatedTour, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Tour not found", HttpStatus.NOT_FOUND);
        }
    }
}
