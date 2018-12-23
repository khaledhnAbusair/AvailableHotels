package com.abusair.hotel.rest;

import com.abusair.hotel.response.HotelResponse;
import com.abusair.hotel.service.besthotel.BestHotelService;
import com.abusair.hotel.service.crazyhotel.CrazyHotelService;
import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/beam/api")
public class HotelsController {

    @Autowired
    private BestHotelService bestHotelService;
    @Autowired
    private CrazyHotelService crazyHotelService;

    @GetMapping("/availableHotels")
    public List<HotelResponse> availableHotel() {
        List<HotelResponse> hotelResponses = ListUtils.union(bestHotelService.getBestHotels(), crazyHotelService.getCrazyHotels());
        hotelResponses.sort((o1, o2) -> o2.getRate().compareTo(o1.getRate()));
        return hotelResponses;
    }
}
