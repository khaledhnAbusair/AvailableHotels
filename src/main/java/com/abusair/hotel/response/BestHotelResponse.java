package com.abusair.hotel.response;

public class BestHotelResponse {
    private String hotel;
    private double hotelRate;
    private double hotelFare;
    private String roomAmenities;

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public double getHotelRate() {
        return hotelRate;
    }

    public void setHotelRate(double hotelRate) {
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
