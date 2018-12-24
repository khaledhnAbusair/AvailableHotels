package com.abusair.hotel.service.crazyhotel;

import com.abusair.hotel.dao.crazyhotel.CrazyHotelDao;
import com.abusair.hotel.request.HotelRequest;
import com.abusair.hotel.response.HotelResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The CrazyHotelServiceImpl class responsible for communication with data layer
 *
 * @author Khaled Absauir
 * @version 1.0
 */
@Service
public class CrazyHotelServiceImpl implements CrazyHotelService {
    /**
     * The CrazyHotelDao is a class responsible for communicate with data access layer.
     */
    @Autowired
    private CrazyHotelDao crazyHotelDao;

    /**
     * Returns a list of hotel response.
     * When this applet attempts to get crazyHotels Response.
     *
     * @param HotelRequest
     * @return List<HotelResponse>
     */
    @Override
    public List<HotelResponse> getCrazyHotels(HotelRequest request) {
        return crazyHotelDao.getCrazyHotel(request);
    }
}
