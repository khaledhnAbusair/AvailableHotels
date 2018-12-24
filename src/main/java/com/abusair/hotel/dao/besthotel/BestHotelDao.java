package com.abusair.hotel.dao.besthotel;

import com.abusair.hotel.request.HotelRequest;
import com.abusair.hotel.response.HotelResponse;

import java.util.List;

/**
 * The BestHotelDao class responsible for communication between app and data access layer
 *
 * @author Khaled Absauir
 * @version 1.0
 */
public interface BestHotelDao {


    /**
     * Returns a list of hotel.
     * This method always returns List<HotelResponse>.
     *
     * @param HotelRequest
     * @return List<HotelResponse>
     */
    List<HotelResponse> getBestHotels(HotelRequest request);
}
