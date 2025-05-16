package com.example.moviebooking.controller;

import com.example.moviebooking.dto.TheatreShowDTO;
import com.example.moviebooking.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/shows")
public class ShowController {

    @Autowired
    private ShowService showService;

    @GetMapping("/search")
    public ResponseEntity<?> getShows(@RequestParam String movie,
                                      @RequestParam String city,
                                      @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<TheatreShowDTO> result = showService.getShows(movie, city, date);
        Map<String, Object> response = Map.of(
            "movie", movie,
            "city", city,
            "date", date.toString(),
            "theatres", result
        );
        return ResponseEntity.ok(response);
    }
}
