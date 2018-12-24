package com.abusair.hotel.request;

import java.time.Instant;

public class CrazyHotelRequest {

    private Instant from;
    private Instant to;
    private String city;
    private int adultsCount;

    public Instant getFrom() {
        return from;
    }

    public void setFrom(Instant from) {
        this.from = from;
    }

    public Instant getTo() {
        return to;
    }

    public void setTo(Instant to) {
        this.to = to;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAdultsCount() {
        return adultsCount;
    }

    public void setAdultsCount(int adultsCount) {
        this.adultsCount = adultsCount;
    }

    @Override
    public String toString() {
        return "CrazyHotelRequest{" +
                "from=" + from +
                ", to=" + to +
                ", city='" + city + '\'' +
                ", adultsCount=" + adultsCount +
                '}';
    }
}
