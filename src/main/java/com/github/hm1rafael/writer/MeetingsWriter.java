package com.github.hm1rafael.writer;

import com.github.hm1rafael.pojo.ScheduledMeeting;

import java.io.File;
import java.util.Collection;
import java.util.List;

public interface MeetingsWriter {

    void write(File destinationFolder, Collection<ScheduledMeeting> meetings);

}
