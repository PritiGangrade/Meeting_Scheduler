package com.meeting;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Created by Priti on 5/4/15.
 */
public class SolutionTest {

    private Solution solution;

    @Test
    public void verifyOrderByPriorityOnly() {
        setupVerifyOnlyPriority();
        int[] actual = solution.schedule();
        Assert.assertNotNull(actual);
        Assert.assertEquals("Number of elements in the ordered array do not match number of rooms", 2, actual.length);
        Assert.assertEquals("Meeting ids do not match expected value", 3, actual[0]);
        Assert.assertEquals("Meeting ids do not match expected value", 2, actual[1]);
        solution.printScheduledMeetings(actual);
    }

    @Test
    public void verifyOrderByPriorityThenStartDate() {
        setupVerifyPriorityThenStartDate();
        int[] actual = solution.schedule();
        Assert.assertNotNull(actual);
        Assert.assertEquals("Number of elements in the ordered array do not match number of rooms", 2, actual.length);
        Assert.assertEquals("Meeting ids do not match expected value", 3, actual[0]);
        Assert.assertEquals("Meeting ids do not match expected value", 2, actual[1]);
        solution.printScheduledMeetings(actual);
    }

    @Before
    public void intialize() {
        solution = new Solution();
    }

    private void setupVerifyOnlyPriority() {
        String verifyOrderByPriority = getFile("meeting_input_sample_by_priority.txt");
        intializeScanner(verifyOrderByPriority);
    }

    private void setupVerifyPriorityThenStartDate() {
        String verifyOrderByPriorityThenStartDate = getFile("meeting_input_sample_by_priority_then_starttime.txt");
        intializeScanner(verifyOrderByPriorityThenStartDate);
    }

    private void intializeScanner(String testDataAsString) {
        if (StringUtils.isNotBlank(testDataAsString)) {
            InputStream stream = new ByteArrayInputStream(testDataAsString.getBytes(StandardCharsets.UTF_8));
            Scanner scanner = new Scanner(stream);
            solution.setScanner(scanner);
        }
    }

    private String getFile(String fileName) {
        StringBuilder result = new StringBuilder("");
        ClassLoader classLoader = getClass().getClassLoader();

        File file = new File(classLoader.getResource(fileName).getFile());
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}
