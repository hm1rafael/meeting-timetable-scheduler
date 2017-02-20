package com.github.hm1rafael;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;


public class ScheduleTimeTest {

    @Test
    public void checkIfFitsAllMeetingsTest() throws IOException {
        checkOutput("src/test/resources/example-input.txt", "src/test/resources/correctOutput/example-output.txt");
    }

    @Test
    public void ifDoesntFitAllTest() throws IOException {
        checkOutput("src/test/resources/doesnotfitall-test.txt", "src/test/resources/correctOutput/doesnotfitall-output.txt");
    }

    @Test
    public void noMeetingsTest() throws IOException {
        checkOutput("src/test/resources/nomeetings.txt", "src/test/resources/correctOutput/nomeetings-output.txt");
    }

    private void checkOutput(String inputPath, String expectedOutputPath) throws IOException {
        MeetingProcessor meetingProcessor = new MeetingProcessor();
        meetingProcessor.scheduleMeetings(new File(inputPath));
        File generatedOutputFile = new File("src/test/resources/output.txt");
        byte[] generatedOutput = Files.readAllBytes(generatedOutputFile.toPath());
        File expectedOutputFile = new File(expectedOutputPath);
        byte[] expectedOutput = Files.readAllBytes(expectedOutputFile.toPath());
        Assert.assertTrue(Arrays.equals(generatedOutput, expectedOutput));
        generatedOutputFile.delete();
    }



}
