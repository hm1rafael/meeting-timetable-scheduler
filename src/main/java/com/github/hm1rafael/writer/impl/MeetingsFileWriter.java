package com.github.hm1rafael.writer.impl;

import com.github.hm1rafael.pojo.ScheduledMeeting;
import com.github.hm1rafael.writer.MeetingsWriter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MeetingsFileWriter implements MeetingsWriter {

    public static final String OUTPUT_FILE = "output.txt";

    public void write(File destinationFolder, Collection<ScheduledMeeting> meetings) {
        List<String> collect = meetings.stream()
                .map(ScheduledMeeting::toString)
                .collect(Collectors.toList());
        try {
            Files.write(new File(destinationFolder, OUTPUT_FILE).toPath(), collect);
        } catch (IOException e) {
            throw new IllegalStateException("Problems writing the file", e);
        }
    }

}
