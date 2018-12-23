package com.abusair.hotel.dao;

import com.abusair.hotel.response.HotelResponse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HotelDaoImpl implements HotelDao {

    @Override
    public List<HotelResponse> getHotels() {
        return null;
    }
}
