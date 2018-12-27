package com.abusair.hotel.dao.besthotel;

import com.abusair.hotel.exception.DateTimeFormatException;
import com.abusair.hotel.request.HotelRequest;
import com.abusair.hotel.response.HotelResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(BestHotelDaoImpl.class)
public class BestHotelDaoImplTest {


    @Autowired
    private BestHotelDao bestHotelDao;

    @Test
    public void givenValidHotelRequest_WhenGetBestHotels_ThenListOfHotelResponseWillBeReturned() {
        List<HotelResponse> bestHotels = bestHotelDao.getBestHotels(getHotelRequest());
        Assert.assertEquals(6, bestHotels.size());
        Assert.assertNotNull(bestHotels);
    }

    @Test(expected = DateTimeFormatException.class)
    public void givenInvalidFromDate_WhenGetBestHotels_ThenDateTimeFormatExceptionBeReturned() {
        bestHotelDao.getBestHotels(getInvalidDateInHotelRequest("2011-12-0s", "2011-12-03"));
    }

    @Test(expected = DateTimeFormatException.class)
    public void givenInvalidToDate_WhenGetBestHotels_ThenDateTimeFormatExceptionBeReturned() {
        bestHotelDao.getBestHotels(getInvalidDateInHotelRequest("2011-12-03", "2011-12-0s"));
    }

    private HotelRequest getHotelRequest() {
        HotelRequest hotelRequest = new HotelRequest();
        hotelRequest.setCity("ADJ");
        hotelRequest.setFromDate("2011-12-03");
        hotelRequest.setToDate("2011-12-03");
        hotelRequest.setNumberOfAdults("2");
        return hotelRequest;
    }

    private HotelRequest getInvalidDateInHotelRequest(String formDate, String toDate) {
        HotelRequest hotelRequest = new HotelRequest();
        hotelRequest.setCity("ADJ");
        hotelRequest.setFromDate(formDate);
        hotelRequest.setToDate(toDate);
        hotelRequest.setNumberOfAdults("2");
        return hotelRequest;
    }
}
