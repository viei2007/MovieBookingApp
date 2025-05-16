package com.example.moviebooking.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Shows")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Show {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long showId;

	private LocalDate showDate;
	private LocalTime showTime;
	private BigDecimal price;
	private Long screen;

	@ManyToOne
	@JoinColumn(name = "TheatreID", nullable = false)
	private Theatre theatre;

	@ManyToOne
	@JoinColumn(name = "MovieID", nullable = false)
	private Movie movie;

	public Long getScreen() {
		// TODO Auto-generated method stub
		return theatre.getScreenID();
	}

	public Object getShowTime() {
		// TODO Auto-generated method stub
		return null;
	}

}
