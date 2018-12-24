package com.abusair.hotel.dao;

import com.abusair.hotel.converters.RequestConverters;
import com.abusair.hotel.converters.ResponseConverters;
import com.abusair.hotel.request.BestHotelRequest;
import com.abusair.hotel.request.HotelRequest;
import com.abusair.hotel.response.BestHotelResponse;
import com.abusair.hotel.response.HotelResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BestHotelDaoImpl implements BestHotelDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(BestHotelDaoImpl.class);

    @Autowired
    private ResourceLoader resourceLoader;
    private List<BestHotelResponse> bestHotelResponses;


    private void loadBestHotelsResponseFile(BestHotelRequest bestHotelRequest) throws IOException {
        LOGGER.info(bestHotelRequest.toString());
        Resource resource = resourceLoader.getResource("classpath:bestHotelsResponse.json");
        File file = resource.getFile();
        ObjectMapper jsonMapper = new ObjectMapper();
        bestHotelResponses = jsonMapper.readValue(file, new TypeReference<List<BestHotelResponse>>() {
        });
    }

    @Override
    public List<HotelResponse> getBestHotels(HotelRequest request) {
        List<HotelResponse> hotelResponses = new ArrayList<>();
        try {
            loadBestHotelsResponseFile(RequestConverters.convertHotelRequestToBestHotelRequest(request));
        } catch (IOException e) {
            LOGGER.debug(e.getMessage());
        }
        bestHotelResponses.forEach(o -> hotelResponses.add(ResponseConverters.convertBestHotelResponseToHotelResponse(o)));
        return hotelResponses;
    }
}
