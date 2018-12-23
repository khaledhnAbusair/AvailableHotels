package com.abusair.hotel.dao.besthotel;

import com.abusair.hotel.converters.ResponseConverters;
import com.abusair.hotel.response.BestHotelResponse;
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
public class BestHotelDaoImpl implements BestHotelDao {
    @Autowired
    private ResourceLoader resourceLoader;
    private List<BestHotelResponse> bestHotelResponses;


    @PostConstruct
    public void loadResponseFile() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:bestHotelsResponse.json");
        File file = resource.getFile();
        ObjectMapper jsonMapper = new ObjectMapper();
        bestHotelResponses = jsonMapper.readValue(file, new TypeReference<List<BestHotelResponse>>() {
        });
    }

    @Override
    public List<HotelResponse> getBestHotels() {
        List<HotelResponse> hotelResponses = new ArrayList<>();
        bestHotelResponses.forEach(o -> hotelResponses.add(ResponseConverters.convertBestHotelResponseToHotelResponse(o)));
        return hotelResponses;
    }
}
