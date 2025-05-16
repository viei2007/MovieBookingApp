package com.example.moviebooking.response;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShowResponse {
	private int showId;
	private String showName;
	private LocalDate showDate;
	private LocalTime showTime;
}
