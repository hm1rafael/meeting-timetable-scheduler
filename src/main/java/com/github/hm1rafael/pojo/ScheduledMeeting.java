package com.github.hm1rafael.pojo;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ScheduledMeeting {

    public ScheduledMeeting(LocalTime startTime, Meeting meeting) {
        this.startTime = startTime;
        this.meeting = meeting;
    }

    private LocalTime startTime;
    private Meeting meeting;

    public LocalTime getStartTime() {
        return this.startTime;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.startTime.format(DateTimeFormatter.ofPattern("HH:mm a")), this.meeting.toString());
    }

}
