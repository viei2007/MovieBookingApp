package com.example.moviebooking.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Theatres")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Theatre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long theatreId;
	private Long screenID;

	private String name;
	private String city;
	private String address;
	private String contactEmail;
	private String contactPhone;

	@OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Show> shows;

	/**
	 * @return the screenID
	 */
	public Long getScreenID() {
		return screenID;
	}

	/**
	 * @param screenID the screenID to set
	 */
	public void setScreenID(Long screenID) {
		this.screenID = screenID;
	}
}
