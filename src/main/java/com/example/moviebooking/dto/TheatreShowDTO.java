package com.example.moviebooking.dto;

import lombok.Data;

import java.util.List;

@Data
public class TheatreShowDTO {
    private String name;
    private String address;
    private List<ShowTimeDTO> shows;
}
