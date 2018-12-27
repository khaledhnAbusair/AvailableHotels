package com.abusair.hotel.service;

import com.abusair.hotel.request.HotelRequest;
import com.abusair.hotel.response.HotelResponse;

import java.util.List;

public interface BaseHotelService {
    List<HotelResponse> getHotels(HotelRequest request);
}
