package com.abusair.hotel.rest;

import com.abusair.hotel.exception.MissingDataParametersException;
import com.abusair.hotel.request.HotelRequest;
import com.abusair.hotel.response.HotelResponse;
import com.abusair.hotel.service.besthotel.BestHotelService;
import com.abusair.hotel.service.crazyhotel.CrazyHotelService;
import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

/**
 * The Available Hotels program implements an application that
 * simply displays all available hotels  to the standard output.
 *
 * @author Khaled Absauir
 * @version 1.0
 */
@RestController
@RequestMapping("/api")
public class HotelsController {
    /**
     * The BestHotelService is a service We communicate with BestHotelDao.
     */
    @Autowired
    private BestHotelService bestHotelService;
    /**
     * The CrazyHotelService is a service We communicate with CrazyHotelDao.
     */
    @Autowired
    private CrazyHotelService crazyHotelService;

    /**
     * Returns an List of available HotelResponse that can then be show as json.
     * The url argument must specify an absolute {@link URL}. The name
     * argument is a specifier that is relative to the url argument.
     * <p>
     * This method always returns immediately, whether or not the
     * hotel exists. When this applet attempts to get all available hotels
     * the data will be loaded.
     *
     * @param url http://localhost:1015/api/availableHotels?fromDate=yyyy-MM-dd&toDate=yyyy-MM-dd&city=IATA code&numberOfAdults=>=0
     * @return List of available hotels
     */
    @GetMapping(value = "/availableHotels", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<HotelResponse> availableHotel(@Valid @ModelAttribute HotelRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            throw new MissingDataParametersException(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        List<HotelResponse> hotelResponses = ListUtils.union(bestHotelService.getBestHotels(request), crazyHotelService.getCrazyHotels(request));
        hotelResponses.sort((o1, o2) -> o2.getRate().compareTo(o1.getRate()));
        return hotelResponses;
    }
}
