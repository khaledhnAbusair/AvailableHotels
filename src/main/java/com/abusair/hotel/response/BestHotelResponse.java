package com.abusair.hotel.response;

import com.fasterxml.jackson.annotation.JsonProperty;


public class BestHotelResponse {
    @JsonProperty("hotel")
    private String hotel;
    @JsonProperty("hotel_rate")
    private Integer hotelRate;
    @JsonProperty("hotel_fare")
    private double hotelFare;
    @JsonProperty("room_amenities")
    private String roomAmenities;

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public Integer getHotelRate() {
        return hotelRate;
    }

    public void setHotelRate(Integer hotelRate) {
        this.hotelRate = hotelRate;
    }

    public double getHotelFare() {
        return hotelFare;
    }

    public void setHotelFare(double hotelFare) {
        this.hotelFare = hotelFare;
    }

    public String getRoomAmenities() {
        return roomAmenities;
    }

    public void setRoomAmenities(String roomAmenities) {
        this.roomAmenities = roomAmenities;
    }
}
