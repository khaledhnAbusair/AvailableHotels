package com.abusair.hotel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class HotelRestExceptionHandler {

    @ResponseBody
    @ExceptionHandler(MissingDataParametersException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public HotelErrorResponse handleMissingDataParametersException(MissingDataParametersException e) {
        HotelErrorResponse errorResponse = new HotelErrorResponse();
        errorResponse.setMessage(e.getMessage());
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.toString());
        errorResponse.setTimeStamp(System.currentTimeMillis());
        return errorResponse;
    }


    @ResponseBody
    @ExceptionHandler(DateTimeFormatException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public HotelErrorResponse handleDateTimeFormatException(DateTimeFormatException e) {
        HotelErrorResponse errorResponse = new HotelErrorResponse();
        errorResponse.setMessage(e.getMessage());
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.toString());
        errorResponse.setTimeStamp(System.currentTimeMillis());
        return errorResponse;
    }

    @ResponseBody
    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public HotelErrorResponse handleNumberFormatException(NumberFormatException e) {
        HotelErrorResponse errorResponse = new HotelErrorResponse();
        errorResponse.setMessage("Number format error : " + e.getMessage());
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.toString());
        errorResponse.setTimeStamp(System.currentTimeMillis());
        return errorResponse;
    }
}
