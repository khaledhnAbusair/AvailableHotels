package com.abusair.hotel.dao.crazyhotel;

import com.abusair.hotel.exception.DateTimeFormatException;
import com.abusair.hotel.request.HotelRequest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@WebMvcTest(CrazyHotelDaoImpl.class)
public class CrazyHotelDaoImplTest {

    @Autowired
    private CrazyHotelDao crazyHotelDao;

    @Test
    public void givenValidValidHotelRequest_WhenGetBestHotels_ThenListOfHotelResponseWillBeReturned() {
        Assert.assertNotNull(crazyHotelDao.getCrazyHotel(getHotelRequest()));
    }

    @Test(expected = DateTimeFormatException.class)
    public void givenInvalidFromDate_WhenGetBestHotels_ThenDateTimeFormatExceptionBeReturned() {
        crazyHotelDao.getCrazyHotel(getInvalidHotelRequest("2011-12-0s", "2011-12-03", "2"));
    }

    @Test(expected = DateTimeFormatException.class)
    public void givenInvalidToDate_WhenGetBestHotels_ThenDateTimeFormatExceptionBeReturned() {
        crazyHotelDao.getCrazyHotel(getInvalidHotelRequest("2011-12-03", "2011-12-0s", "2"));
    }

    @Test(expected = NumberFormatException.class)
    public void givenInvalidNumberOfAdults_WhenGetBestHotels_ThenNumberFormatExceptionBeReturned() {
        crazyHotelDao.getCrazyHotel(getInvalidHotelRequest("2011-12-03", "2011-12-03", "a"));
    }

    private HotelRequest getHotelRequest() {
        HotelRequest hotelRequest = new HotelRequest();
        hotelRequest.setCity("ADJ");
        hotelRequest.setFromDate("2011-12-03");
        hotelRequest.setToDate("2011-12-03");
        hotelRequest.setNumberOfAdults("2");
        return hotelRequest;
    }

    private HotelRequest getInvalidHotelRequest(String formDate, String toDate, String number) {
        HotelRequest hotelRequest = new HotelRequest();
        hotelRequest.setCity("ADJ");
        hotelRequest.setFromDate(formDate);
        hotelRequest.setToDate(toDate);
        hotelRequest.setNumberOfAdults(number);
        return hotelRequest;
    }
}
