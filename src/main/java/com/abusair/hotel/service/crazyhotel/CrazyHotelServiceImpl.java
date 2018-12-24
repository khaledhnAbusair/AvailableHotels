package com.abusair.hotel.service.crazyhotel;

import com.abusair.hotel.dao.crazyhotel.CrazyHotelDao;
import com.abusair.hotel.request.HotelRequest;
import com.abusair.hotel.response.HotelResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrazyHotelServiceImpl implements CrazyHotelService {
    @Autowired
    private CrazyHotelDao crazyHotelDao;

    @Override
    public List<HotelResponse> getCrazyHotels(HotelRequest request) {
        return crazyHotelDao.getCrazyHotel(request);
    }
}
