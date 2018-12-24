package com.abusair.hotel.service.besthotel;

import com.abusair.hotel.request.HotelRequest;
import com.abusair.hotel.response.HotelResponse;

import java.util.List;

/**
 * The BestHotelService class responsible for communication between app and dao layer
 *
 * @author Khaled Absauir
 * @version 1.0
 */
public interface BestHotelService {
    /**
     * Returns a list of hotel.
     * This method always returns List<HotelResponse>.
     *
     * @param HotelRequest
     * @return List<HotelResponse>
     */
    List<HotelResponse> getBestHotels(HotelRequest request);
}
