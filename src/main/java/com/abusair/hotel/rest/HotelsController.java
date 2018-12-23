package com.abusair.hotel.rest;

import com.abusair.hotel.response.HotelResponse;
import com.abusair.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/beam/api")
public class HotelsController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/availableHotels")
    public List<HotelResponse> availableHotel() {
        return hotelService.getHotels();
    }

}
