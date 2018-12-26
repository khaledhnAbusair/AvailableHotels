package com.abusair.hotel.request;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@RunWith(SpringRunner.class)
@WebMvcTest(CrazyHotelRequest.class)
public class CrazyHotelRequestTest {
    private Instant date;

    @Before
    public void setup() {
        date = LocalDate.parse("2013-12-03", DateTimeFormatter.ISO_LOCAL_DATE).atStartOfDay().toInstant(ZoneOffset.UTC);
    }

    @Test
    public void givenValidCrazyHotelRequest_WhenSetCity_ThenReturnCity() {
        Assert.assertEquals("ADJ", getCrazyHotelRequest().getCity());
    }

    @Test
    public void givenValidCrazyHotelRequest_WhenSetFromDate_ThenReturnFromDate() {
        Assert.assertEquals(LocalDate.parse("2013-12-03", DateTimeFormatter.ISO_LOCAL_DATE).atStartOfDay().toInstant(ZoneOffset.UTC), getCrazyHotelRequest().getFrom());
    }

    @Test
    public void givenValidCrazyHotelRequest_WhenSetToDate_ThenReturnToDate() {
        Assert.assertEquals(LocalDate.parse("2013-12-03", DateTimeFormatter.ISO_LOCAL_DATE).atStartOfDay().toInstant(ZoneOffset.UTC), getCrazyHotelRequest().getTo());
    }

    @Test
    public void givenValidCrazyHotelRequest_WhenSetNumberOfAdults_ThenReturnNumberOfAdults() {
        Assert.assertEquals(2, getCrazyHotelRequest().getAdultsCount());
    }

    @Test
    public void givenValidCrazyHotelRequest_WhenSCallToString_ThenReturnToString() {
        Assert.assertNotNull(getCrazyHotelRequest().toString());
    }

    private CrazyHotelRequest getCrazyHotelRequest() {
        CrazyHotelRequest crazyHotelRequest = new CrazyHotelRequest();
        crazyHotelRequest.setCity("ADJ");
        crazyHotelRequest.setTo(date);
        crazyHotelRequest.setFrom(date);
        crazyHotelRequest.setAdultsCount(2);
        return crazyHotelRequest;
    }
}
