package com.adrian.museum.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

/**
 * Class to map the information from museums entries
 * Created by Adrian
 */
@Getter
@Setter
public class MuseumEntry {

    private LocalTime arrivalTime;
    private LocalTime leavingTime;
    private int visitorsDuringPeriod;

    public MuseumEntry(LocalTime arrivalTime, LocalTime leavingTime) {
        this.arrivalTime = arrivalTime;
        this.leavingTime = leavingTime;
    }

    @Override
    public String toString() {
        return "start time=" + arrivalTime +
                ", time period end=" + leavingTime +
                ", number of visitors=" + visitorsDuringPeriod;
    }
}
