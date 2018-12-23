package com.abusair.hotel.service.besthotel;

import com.abusair.hotel.dao.besthotel.BestHotelDao;
import com.abusair.hotel.response.HotelResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BestHotelServiceImpl implements BestHotelService {
    @Autowired
    private BestHotelDao bestHotelDao;

    @Override
    public List<HotelResponse> getHotels() {
        return bestHotelDao.getBestHotels();
    }
}
