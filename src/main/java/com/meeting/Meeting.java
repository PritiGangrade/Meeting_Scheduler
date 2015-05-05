package com.meeting;

/**
 * POJO that contains information about Meeting
 * Created by Priti on 5/4/15.
 */

public class Meeting {
    int meetingId;
    long startTime;
    long endTime;
    int priority;
    String name;

    public Meeting(int meetingId, long startTime, long endTime, int priority, String name) {
        this.meetingId = meetingId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;
        this.name = name;
    }

    public int getMeetingId() {
        return meetingId;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public int getPriority() {
        return priority;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "MeetingId: " + meetingId + ", startTime: " + startTime + ", priority: " + priority + ", name: " + name;
    }
}