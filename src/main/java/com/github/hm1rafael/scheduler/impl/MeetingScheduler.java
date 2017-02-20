package com.github.hm1rafael.scheduler.impl;


import com.github.hm1rafael.pojo.Meeting;
import com.github.hm1rafael.pojo.ScheduledMeeting;
import com.github.hm1rafael.scheduler.MeetingsScheduler;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class MeetingScheduler implements MeetingsScheduler {

    private LocalTime DAY_MEETING = LocalTime.of(17, 46);
    private LocalTime LUNCH = LocalTime.NOON.plusMinutes(1L);

    public Collection<ScheduledMeeting> schedule(List<Meeting> meetings) {
        Set<ScheduledMeeting> scheduledMeetings = new TreeSet<>(Comparator.comparing(ScheduledMeeting::getStartTime));
        LocalTime morningPeriod = LocalTime.of(9, 0);
        LocalTime afternoonPeriod = LocalTime.of(13, 0);
        for (Meeting meeting: meetings) {
            if (fitsBeforeRequiredTime(morningPeriod, meeting, LUNCH)) {
                scheduledMeetings.add(new ScheduledMeeting(morningPeriod, meeting));
                morningPeriod = morningPeriod.plusMinutes(meeting.getDuration().longValue());
            } else if (fitsBeforeRequiredTime(afternoonPeriod, meeting, DAY_MEETING)) {
                scheduledMeetings.add(new ScheduledMeeting(afternoonPeriod, meeting));
                afternoonPeriod = afternoonPeriod.plusMinutes(meeting.getDuration().longValue());
            }
        }
        scheduledMeetings.add(new ScheduledMeeting(LUNCH.plusMinutes(-1L), new Meeting("Lunch", 60)));
        scheduledMeetings.add(new ScheduledMeeting(DAY_MEETING.plusMinutes(-1L), new Meeting("Day Meeting", 15)));
        return scheduledMeetings;
    }

    private boolean fitsBeforeRequiredTime(LocalTime currentTime, Meeting meeting, LocalTime requiredTime) {
        return currentTime.plus(meeting.getDuration().longValue(), ChronoUnit.MINUTES).isBefore(requiredTime);
    }



}
