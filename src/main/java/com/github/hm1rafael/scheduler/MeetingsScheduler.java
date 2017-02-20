package com.github.hm1rafael.scheduler;

import com.github.hm1rafael.pojo.Meeting;
import com.github.hm1rafael.pojo.ScheduledMeeting;

import java.util.Collection;
import java.util.List;

public interface MeetingsScheduler {

    Collection<ScheduledMeeting> schedule(List<Meeting> meetings);

}
