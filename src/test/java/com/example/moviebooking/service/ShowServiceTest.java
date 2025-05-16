package com.example.moviebooking.service;

import com.example.moviebooking.repository.ShowRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ShowServiceTest {

    @Mock
    private ShowRepository showRepository;

    @InjectMocks
    private ShowService showService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetShows() {
        // TODO: Add mock behavior and assertions
    }
}
