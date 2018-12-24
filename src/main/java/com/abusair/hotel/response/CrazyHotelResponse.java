package com.abusair.hotel.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CrazyHotelResponse {
    @JsonProperty("hotel_name")
    private String hotelName;
    @JsonProperty("rate")
    private String hotelRate;
    @JsonProperty("price")
    private double price;
    @JsonProperty("discount")
    private double discount;
    @JsonProperty("amenities")
    private String[] amenities;

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelRate() {
        return hotelRate;
    }

    public void setHotelRate(String hotelRate) {
        this.hotelRate = hotelRate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String[] getAmenities() {
        return amenities;
    }

    public void setAmenities(String[] amenities) {
        this.amenities = amenities;
    }
}
