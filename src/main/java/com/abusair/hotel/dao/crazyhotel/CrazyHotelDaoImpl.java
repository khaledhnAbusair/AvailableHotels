package com.abusair.hotel.dao.crazyhotel;

import com.abusair.hotel.converters.RequestConverters;
import com.abusair.hotel.converters.ResponseConverters;
import com.abusair.hotel.request.CrazyHotelRequest;
import com.abusair.hotel.request.HotelRequest;
import com.abusair.hotel.response.CrazyHotelResponse;
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
 * The CrazyHotelDaoImpl class responsible for implementing data access layer
 *
 * @author Khaled Absauir
 * @version 1.0
 */
@Repository
public class CrazyHotelDaoImpl implements CrazyHotelDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(CrazyHotelDaoImpl.class);
    /**
     * The resourceLoader is a class responsible for load class in resource file.
     */
    @Autowired
    private ResourceLoader resourceLoader;
    private List<CrazyHotelResponse> crazyHotelResponses;

    /**
     * Returns a void.
     * When this applet attempts to load Crazy Hotels Response File
     *
     * @param CrazyHotelRequest
     * @return void
     */
    public void loadCrazyHotelsResponseFile(CrazyHotelRequest crazyHotelRequest) throws IOException {
        LOGGER.info(crazyHotelRequest.toString());
        Resource resource = resourceLoader.getResource("classpath:crazyHotelsResponse.json");
        File file = resource.getFile();
        ObjectMapper jsonMapper = new ObjectMapper();
        crazyHotelResponses = jsonMapper.readValue(file, new TypeReference<List<CrazyHotelResponse>>() {
        });
    }

    /**
     * Returns a list of hotel response.
     * When this applet attempts to get Crazy Hotel from resource file
     *
     * @param HotelRequest
     * @return List<HotelResponse>
     */
    @Override
    public List<HotelResponse> getCrazyHotel(HotelRequest request) {
        List<HotelResponse> hotelResponses = new ArrayList<>();
        try {
            loadCrazyHotelsResponseFile(RequestConverters.convertHotelRequestToCrazyHotelRequest(request));
        } catch (IOException e) {
            LOGGER.debug(e.getMessage());
        }
        crazyHotelResponses.forEach(o -> hotelResponses.add(ResponseConverters.convertCrazyHotelResponseToHotelResponse(o)));
        return hotelResponses;
    }
}
