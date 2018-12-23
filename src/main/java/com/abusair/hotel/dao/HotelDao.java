package com.abusair.hotel.dao;

import com.abusair.hotel.response.HotelResponse;

import java.util.List;

public interface HotelDao {
    List<HotelResponse> getHotels();
}
