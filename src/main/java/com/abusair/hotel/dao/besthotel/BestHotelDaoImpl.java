package com.abusair.hotel.dao.besthotel;

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


/**
 * The BestHotelDaoImpl class responsible for implementing data access layer
 *
 * @author Khaled Absauir
 * @version 1.0
 */
@Repository
public class BestHotelDaoImpl implements BestHotelDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(BestHotelDaoImpl.class);

    /**
     * The resourceLoader is a class responsible for load class in resource file.
     */
    @Autowired
    private ResourceLoader resourceLoader;
    private List<BestHotelResponse> bestHotelResponses;

    /**
     * Returns a void.
     * When this applet attempts to load BestHotels Response File
     *
     * @param BestHotelRequest
     * @return void
     */
    private void loadBestHotelsResponseFile(BestHotelRequest bestHotelRequest) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:bestHotelsResponse.json");
        File file = resource.getFile();
        ObjectMapper jsonMapper = new ObjectMapper();
        bestHotelResponses = jsonMapper.readValue(file, new TypeReference<List<BestHotelResponse>>() {
        });
    }

    /**
     * Returns a list of hotel response.
     * When this applet attempts to getBestHotels from resource file
     *
     * @param HotelRequest
     * @return List<HotelResponse>
     */
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
