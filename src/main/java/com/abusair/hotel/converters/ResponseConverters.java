package com.abusair.hotel.converters;

import com.abusair.hotel.response.BestHotelResponse;
import com.abusair.hotel.response.HotelResponse;

public class ResponseConverters {

    public static HotelResponse convertBestHotelResponseToHotelResponse(BestHotelResponse response) {
        HotelResponse hotelResponse = new HotelResponse();
        hotelResponse.setProviderName("Best Hotels");
        hotelResponse.setFare(response.getHotelFare());
        hotelResponse.setHotelName(response.getHotel());
        hotelResponse.setAmenities(response.getRoomAmenities().split(","));
        hotelResponse.setRate(response.getHotelRate());
        return hotelResponse;
    }
}