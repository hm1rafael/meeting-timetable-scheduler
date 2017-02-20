package com.github.hm1rafael.reader.impl;

import com.github.hm1rafael.pojo.Meeting;
import com.github.hm1rafael.reader.MeetingsReader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class MeetingsFileReader implements MeetingsReader {

    public static final String MEETING_DEFINITION_SEPARATOR = "-";

    public List<Meeting> read(File input) {
        try {
            return Files.lines(input.toPath())
                    .map(meetingDefinition -> meetingDefinition.split(MEETING_DEFINITION_SEPARATOR))
                    .map(meetingAttributes -> new Meeting(meetingAttributes[0], parseTime(meetingAttributes[1])))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new IllegalStateException("Problems reading the file", e);
        }
    }

    private Integer parseTime(String meetingAttribute) {
        return Integer.parseInt(meetingAttribute.replaceAll("[^0-9]",""));
    }

    private String[] split(String meetingDefinition) {
        int i = meetingDefinition.lastIndexOf(MEETING_DEFINITION_SEPARATOR);
        return new String[]{ meetingDefinition.substring(0, i).trim(), meetingDefinition.substring(i + 1).trim() };
    }


}
