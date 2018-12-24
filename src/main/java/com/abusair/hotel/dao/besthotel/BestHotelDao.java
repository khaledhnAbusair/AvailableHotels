package com.abusair.hotel.dao.besthotel;

import com.abusair.hotel.request.HotelRequest;
import com.abusair.hotel.response.HotelResponse;

import java.util.List;


public interface BestHotelDao {
    List<HotelResponse> getBestHotels(HotelRequest request);
}
