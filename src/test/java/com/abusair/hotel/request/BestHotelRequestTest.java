package com.abusair.hotel.request;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RunWith(SpringRunner.class)
@WebMvcTest(BestHotelRequest.class)
public class BestHotelRequestTest {
    private LocalDate date;

    @Before
    public void setup() {
        date = LocalDate.parse("2011-12-03", DateTimeFormatter.ISO_LOCAL_DATE);
    }

    @Test
    public void givenValidBestHotelRequest_WhenSetCity_ThenReturnCity() {
        Assert.assertEquals("ADJ", getBestHotelRequest().getCity());
    }

    @Test
    public void givenValidBestHotelRequest_WhenSetFromDate_ThenReturnFromDate() {
        Assert.assertEquals(LocalDate.parse("2011-12-03", DateTimeFormatter.ISO_LOCAL_DATE), getBestHotelRequest().getFromDate());
    }

    @Test
    public void givenValidBestHotelRequest_WhenSetToDate_ThenReturnToDate() {
        Assert.assertEquals(LocalDate.parse("2011-12-03", DateTimeFormatter.ISO_LOCAL_DATE), getBestHotelRequest().getToDate());
    }

    @Test
    public void givenValidBestHotelRequest_WhenSetNumberOfAdults_ThenReturnNumberOfAdults() {
        Assert.assertEquals(2, getBestHotelRequest().getNumberOfAdults());
    }

    @Test
    public void givenValidBestHotelRequest_WhenSCallToString_ThenReturnToString() {
        Assert.assertNotNull(getBestHotelRequest().toString());
    }

    private BestHotelRequest getBestHotelRequest() {
        BestHotelRequest bestHotelRequest = new BestHotelRequest();
        bestHotelRequest.setCity("ADJ");
        bestHotelRequest.setToDate(date);
        bestHotelRequest.setFromDate(date);
        bestHotelRequest.setNumberOfAdults(2);
        return bestHotelRequest;
    }
}
