package com.abusair.hotel.exception.handler;

import com.abusair.hotel.exception.DateTimeFormatException;
import com.abusair.hotel.exception.MissingDataParametersException;
import com.abusair.hotel.exception.response.HotelErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ControllerAdvice
public class HotelRestExceptionHandler {

    @ResponseBody
    @ExceptionHandler(MissingDataParametersException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public HotelErrorResponse handleMissingDataParametersException(MissingDataParametersException e) {
        return getHotelErrorResponse(e.getMessage());
    }


    @ResponseBody
    @ExceptionHandler(DateTimeFormatException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public HotelErrorResponse handleDateTimeFormatException(DateTimeFormatException e) {
        return getHotelErrorResponse(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public HotelErrorResponse handleNumberFormatException(NumberFormatException e) {
        return getHotelErrorResponse("Number format error : " + e.getMessage());
    }

    private HotelErrorResponse getHotelErrorResponse(String message) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        HotelErrorResponse errorResponse = new HotelErrorResponse();
        errorResponse.setMessage(message);
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.toString());
        errorResponse.setDate(formatter.format(LocalDateTime.now()));
        return errorResponse;
    }
}
