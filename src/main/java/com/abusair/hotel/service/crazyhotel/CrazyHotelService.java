package com.abusair.hotel.service.crazyhotel;

import com.abusair.hotel.request.HotelRequest;
import com.abusair.hotel.response.HotelResponse;

import java.util.List;


public interface CrazyHotelService {
    List<HotelResponse> getCrazyHotels(HotelRequest request);

}
