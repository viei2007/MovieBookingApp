package com.example.moviebooking.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.moviebooking.dto.ShowTimeDTO;
import com.example.moviebooking.dto.TheatreShowDTO;
import com.example.moviebooking.entity.Show;
import com.example.moviebooking.entity.Theatre;
import com.example.moviebooking.repository.ShowRepository;

@Service
public class ShowService {

	@Autowired
	private ShowRepository showRepository;

	public List<TheatreShowDTO> getShows(String movie, String city, LocalDate date) {
		List<Show> shows = showRepository.findShows(movie, city, date);

		Map<Object, List<Show>> theatreMap = shows.stream()
				.collect(Collectors.groupingBy(s -> s.getScreen().getTheatre()));

		return theatreMap.entrySet().stream().map(entry -> {
			Theatre t = entry.getKey();
			List<ShowTimeDTO> showTimes = entry.getValue().stream().map(show -> {
				ShowTimeDTO dto = new ShowTimeDTO();
				dto.setTime(show.getShowTime().toString());
				dto.setScreen(show.getScreen().getName());
				return dto;
			}).collect(Collectors.toList());

			TheatreShowDTO dto = new TheatreShowDTO();
			dto.setName(t.getName());
			dto.setAddress(t.getAddress());
			dto.setShows(showTimes);
			return dto;
		}).collect(Collectors.toList());
	}
}
