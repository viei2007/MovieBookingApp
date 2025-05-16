package com.example.moviebooking.model;

import java.util.List;

import lombok.Data;

@Data
public class TheatreShowDTO {
    private String name;
    private String address;
    private List<ShowTimeDTO> shows;
}