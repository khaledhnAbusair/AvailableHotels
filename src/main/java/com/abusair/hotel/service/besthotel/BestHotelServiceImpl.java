package com.abusair.hotel.service.besthotel;

import com.abusair.hotel.dao.besthotel.BestHotelDao;
import com.abusair.hotel.request.HotelRequest;
import com.abusair.hotel.response.HotelResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The BestHotelServiceImpl class responsible for communication with data layer
 *
 * @author Khaled Absauir
 * @version 1.0
 */
@Service
public class BestHotelServiceImpl implements BestHotelService {
    /**
     * The BestHotelDao is a class responsible for communicate with data access layer.
     */
    @Autowired
    private BestHotelDao bestHotelDao;
    /**
     * Returns a list of hotel response.
     * When this applet attempts to get BestHotels Response.
     *
     * @param HotelRequest
     * @return List<HotelResponse>
     */
    @Override
    public List<HotelResponse> getBestHotels(HotelRequest request) {
        return bestHotelDao.getBestHotels(request);
    }
}
