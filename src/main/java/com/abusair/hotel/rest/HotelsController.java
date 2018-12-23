package com.abusair.hotel.rest;

import com.abusair.hotel.response.HotelResponse;
import com.abusair.hotel.service.besthotel.BestHotelService;
import com.abusair.hotel.service.crazyhotel.CrazyHotelService;
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
        List<HotelResponse> bestHotelServiceHotels = bestHotelService.getBestHotels();
        List<HotelResponse> crazyHotels = crazyHotelService.getCrazyHotels();
        return crazyHotels;
    }

}
