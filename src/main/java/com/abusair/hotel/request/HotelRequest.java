package com.abusair.hotel.request;

import com.abusair.hotel.validator.CheckDateFormat;

import javax.validation.constraints.NotNull;

public class HotelRequest {
    @CheckDateFormat(pattern = "yyyy-MM-dd", message = "fromDate value is error date format,the correct format is (yyyy-MM-dd)")
    private String fromDate;
    @CheckDateFormat(pattern = "yyyy-MM-dd", message = "toDate value is error date format,the correct format is (yyyy-MM-dd)")
    private String toDate;
    @NotNull(message = "City cannot be empty")
    private String city;
    @NotNull(message = "numberOfAdults must not be empty")
    private String numberOfAdults;

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(String numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }
}
