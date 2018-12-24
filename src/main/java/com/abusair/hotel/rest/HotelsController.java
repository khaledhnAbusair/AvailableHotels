package com.abusair.hotel.rest;

import com.abusair.hotel.exception.MissingDataParametersException;
import com.abusair.hotel.request.HotelRequest;
import com.abusair.hotel.response.HotelResponse;
import com.abusair.hotel.service.besthotel.BestHotelService;
import com.abusair.hotel.service.crazyhotel.CrazyHotelService;
import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HotelsController {

    @Autowired
    private BestHotelService bestHotelService;
    @Autowired
    private CrazyHotelService crazyHotelService;

    @GetMapping(value = "/availableHotels", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<HotelResponse> availableHotel(HotelRequest request) {
        validateRequest(request);
        List<HotelResponse> hotelResponses = ListUtils.union(bestHotelService.getBestHotels(request), crazyHotelService.getCrazyHotels(request));
        hotelResponses.sort((o1, o2) -> o2.getRate().compareTo(o1.getRate()));
        return hotelResponses;
    }

    private void validateRequest(HotelRequest request) {
        if (request.getToDate() == null || request.getFromDate() == null || request.getCity() == null || request.getCity().isEmpty())
            throw new MissingDataParametersException("Missing Url Data Parameters");
    }
}
