package com.github.hm1rafael;


import com.github.hm1rafael.pojo.Meeting;
import com.github.hm1rafael.pojo.ScheduledMeeting;
import com.github.hm1rafael.scheduler.MeetingsScheduler;
import com.github.hm1rafael.scheduler.impl.MeetingScheduler;
import com.github.hm1rafael.reader.MeetingsReader;
import com.github.hm1rafael.reader.impl.MeetingsFileReader;
import com.github.hm1rafael.writer.MeetingsWriter;
import com.github.hm1rafael.writer.impl.MeetingsFileWriter;

import java.io.File;
import java.util.Collection;
import java.util.List;

public class MeetingProcessor {

    private MeetingsReader reader = new MeetingsFileReader();
    private MeetingsScheduler scheduler = new MeetingScheduler();
    private MeetingsWriter writer = new MeetingsFileWriter();

    public static void main(String[] args) {
        if (args.length < 1) {
            throw new IllegalArgumentException("No input file");
        }
        new MeetingProcessor().scheduleMeetings(new File(args[0]));
    }

    public void scheduleMeetings(File input) {
        List<Meeting> meetings = this.reader.read(input);
        Collection<ScheduledMeeting> scheduledMeetings = this.scheduler.schedule(meetings);
        this.writer.write(input.getParentFile(), scheduledMeetings);
    }


}
