package com.abusair.hotel.crazyhotel;

import com.abusair.hotel.request.HotelRequest;
import com.abusair.hotel.response.HotelResponse;

import java.util.List;


public interface CrazyHotelDao {
    List<HotelResponse> getCrazyHotel(HotelRequest request);

}
