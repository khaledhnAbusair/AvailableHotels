package com.abusair.hotel.service.besthotel;

import com.abusair.hotel.request.HotelRequest;
import com.abusair.hotel.response.HotelResponse;

import java.util.List;


public interface BestHotelService {
    List<HotelResponse> getBestHotels(HotelRequest request);
}
