package com.abusair.hotel.request;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@WebMvcTest(HotelRequest.class)
public class HotelRequestTest {

    @Test
    public void givenValidHotelRequest_WhenSetCity_ThenReturnCity() {
        Assert.assertEquals("ADJ", getHotelRequest().getCity());
    }

    @Test
    public void givenValidHotelRequest_WhenSetFromDate_ThenReturnFromDate() {
        Assert.assertEquals("2013-12-03", getHotelRequest().getToDate());
    }

    @Test
    public void givenValidHotelRequest_WhenSetToDate_ThenReturnToDate() {
        Assert.assertEquals("2013-12-03", getHotelRequest().getToDate());
    }

    @Test
    public void givenValidHotelRequest_WhenSetNumberOfAdults_ThenReturnNumberOfAdults() {
        Assert.assertEquals("2", getHotelRequest().getNumberOfAdults());
    }

    @Test
    public void givenValidHotelRequest_WhenSCallToString_ThenReturnToString() {
        Assert.assertNotNull(getHotelRequest().toString());
    }

    private HotelRequest getHotelRequest() {
        HotelRequest hotelRequest = new HotelRequest();
        hotelRequest.setCity("ADJ");
        hotelRequest.setFromDate("2013-12-03");
        hotelRequest.setToDate("2013-12-03");
        hotelRequest.setNumberOfAdults("2");
        return hotelRequest;
    }
}
