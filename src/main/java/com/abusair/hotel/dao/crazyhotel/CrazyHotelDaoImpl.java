package com.abusair.hotel.dao.crazyhotel;

import com.abusair.hotel.converters.ResponseConverters;
import com.abusair.hotel.response.CrazyHotelResponse;
import com.abusair.hotel.response.HotelResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CrazyHotelDaoImpl implements CrazyHotelDao {

    @Autowired
    private ResourceLoader resourceLoader;
    private List<CrazyHotelResponse> crazyHotelResponses;

    @PostConstruct
    public void loadCrazyHotelsResponseFile() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:crazyHotelsResponse.json");
        File file = resource.getFile();
        ObjectMapper jsonMapper = new ObjectMapper();
        crazyHotelResponses = jsonMapper.readValue(file, new TypeReference<List<CrazyHotelResponse>>() {
        });
    }

    @Override
    public List<HotelResponse> getCrazyHotel() {
        List<HotelResponse> hotelResponses = new ArrayList<>();
        crazyHotelResponses.forEach(o -> hotelResponses.add(ResponseConverters.convertCrazyHotelResponseToHotelResponse(o)));
        return hotelResponses;
    }
}
