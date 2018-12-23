package com.abusair.hotel.response;

public class CrazyHotelResponse {
    private String hotelName;
    private String hotelRate;
    private double price;
    private double discount;
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
