package com.abusair.hotel.converters;

import com.abusair.hotel.exception.DateTimeFormatException;
import com.abusair.hotel.request.BestHotelRequest;
import com.abusair.hotel.request.CrazyHotelRequest;
import com.abusair.hotel.request.HotelRequest;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class RequestConverters {

    public static BestHotelRequest convertHotelRequestToBestHotelRequest(HotelRequest request) {
        BestHotelRequest bestHotelRequest = new BestHotelRequest();
        bestHotelRequest.setCity(request.getCity());
        bestHotelRequest.setFromDate(convertStringToLocalDate(request.getFromDate()));
        bestHotelRequest.setToDate(convertStringToLocalDate(request.getToDate()));
        bestHotelRequest.setNumberOfAdults(convertStringToInteger(request.getNumberOfAdults()));
        return bestHotelRequest;
    }

    public static CrazyHotelRequest convertHotelRequestToCrazyHotelRequest(HotelRequest request) {
        CrazyHotelRequest crazyHotelRequest = new CrazyHotelRequest();
        crazyHotelRequest.setCity(request.getCity());
        crazyHotelRequest.setFrom(convertStringToIsoInstant(request.getFromDate()));
        crazyHotelRequest.setTo(convertStringToIsoInstant(request.getToDate()));
        crazyHotelRequest.setAdultsCount(convertStringToInteger(request.getNumberOfAdults()));
        return crazyHotelRequest;
    }


    private static LocalDate convertStringToLocalDate(String date) {
        try {
            return LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
        } catch (DateTimeParseException exception) {
            throw new DateTimeFormatException(exception.getMessage());
        }
    }

    private static Instant convertStringToIsoInstant(String date) {
        try {
            return LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE).atStartOfDay().toInstant(ZoneOffset.UTC);
        } catch (DateTimeParseException exception) {
            throw new DateTimeFormatException(exception.getMessage());
        }
    }

    private static Integer convertStringToInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException exception) {
            throw new NumberFormatException(exception.getMessage());
        }
    }
}
