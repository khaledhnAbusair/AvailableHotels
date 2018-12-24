package com.abusair.hotel.converters;

import com.abusair.hotel.response.BestHotelResponse;
import com.abusair.hotel.response.CrazyHotelResponse;
import com.abusair.hotel.response.HotelResponse;

/**
 * The ResponseConverters class responsible for convert from BestHotelResponse to HotelResponse
 * or CrazyHotelResponse to HotelResponse
 *
 * @author Khaled Absauir
 * @version 1.0
 */
public class ResponseConverters {

    private ResponseConverters() {

    }

    /**
     * Returns a HotelResponse.
     * This method always returns HotelResponse,When this applet attempts to convert from best hotel response to hotel response
     *
     * @param BestHotelResponse
     * @return HotelResponse
     */
    public static HotelResponse convertBestHotelResponseToHotelResponse(BestHotelResponse response) {
        HotelResponse hotelResponse = new HotelResponse();
        hotelResponse.setProviderName("Best Hotels");
        hotelResponse.setFare(response.getHotelFare());
        hotelResponse.setHotelName(response.getHotel());
        hotelResponse.setAmenities(response.getRoomAmenities().split(","));
        hotelResponse.setRate(response.getHotelRate());
        return hotelResponse;
    }

    /**
     * Returns a HotelResponse.
     * This method always returns HotelResponse,When this applet attempts to convert from crazy hotel response to hotel response
     *
     * @param BestHotelResponse
     * @return HotelResponse
     */
    public static HotelResponse convertCrazyHotelResponseToHotelResponse(CrazyHotelResponse response) {
        HotelResponse hotelResponse = new HotelResponse();
        hotelResponse.setProviderName("Crazy Hotels");
        hotelResponse.setFare(response.getPrice());
        hotelResponse.setHotelName(response.getHotelName());
        hotelResponse.setAmenities(response.getAmenities());
        hotelResponse.setRate(response.getHotelRate().length());
        return hotelResponse;
    }
}