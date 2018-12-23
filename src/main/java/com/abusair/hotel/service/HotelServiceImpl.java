package com.abusair.hotel.service;

import com.abusair.hotel.dao.HotelDao;
import com.abusair.hotel.response.HotelResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelDao hotelDao;

    @Override
    public List<HotelResponse> getHotels() {
        return null;
    }
}
