package com.example.moviebooking.dto;

import lombok.Data;
import java.util.List;

@Data
public class BookingRequest {
    private String userId;
    private String showId;
    private List<String> seatNumbers;
    private String paymentMethod;
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the showId
	 */
	public String getShowId() {
		return showId;
	}
	/**
	 * @param showId the showId to set
	 */
	public void setShowId(String showId) {
		this.showId = showId;
	}
	/**
	 * @return the seatNumbers
	 */
	public List<String> getSeatNumbers() {
		return seatNumbers;
	}
	/**
	 * @param seatNumbers the seatNumbers to set
	 */
	public void setSeatNumbers(List<String> seatNumbers) {
		this.seatNumbers = seatNumbers;
	}
	/**
	 * @return the paymentMethod
	 */
	public String getPaymentMethod() {
		return paymentMethod;
	}
	/**
	 * @param paymentMethod the paymentMethod to set
	 */
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
}

