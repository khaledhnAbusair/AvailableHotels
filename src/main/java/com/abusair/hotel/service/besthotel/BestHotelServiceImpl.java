package com.abusair.hotel.service.besthotel;

import com.abusair.hotel.request.HotelRequest;
import com.abusair.hotel.response.HotelResponse;
import com.abusair.hotel.BestHotelDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BestHotelServiceImpl implements BestHotelService {
    @Autowired
    private BestHotelDao bestHotelDao;

    @Override
    public List<HotelResponse> getBestHotels(HotelRequest request) {
        return bestHotelDao.getBestHotels(request);
    }
}
