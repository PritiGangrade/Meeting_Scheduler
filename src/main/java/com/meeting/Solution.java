package com.meeting;

import java.util.*;

/**
 * The purpose of this class is to schedule meetings according to:
 * 1) priority
 * 2) then by start time
 * and print & return array of meetingIds as a result.
 * Created by Priti on 5/4/15.
 */
public class Solution {
    int rooms;
    Scanner scanner;

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] orderedMeetings = solution.schedule();
        solution.printScheduledMeetings(orderedMeetings);
    }

    int[] schedule() {
        List<Meeting> meetings = readData();
        printInputDataBeforeOrdering(meetings);
        return addToPriorityQueue(meetings);
    }

    int[] addToPriorityQueue(List<Meeting> meetings) {
        PriorityQueue<Meeting> meetingQueue = new PriorityQueue<Meeting>(10, new Comparator<Meeting>() {
            public int compare(Meeting meeting1, Meeting meeting2) {
                return ((meeting1.getPriority() == meeting2.getPriority()) ? (new Long(meeting1.getStartTime()).compareTo(new Long(meeting2.getStartTime())))==0 ? 0:
                        (new Long(meeting1.getStartTime()).compareTo(new Long(meeting2.getStartTime())))==1?1:-1:-1);
            }
        });

        for(Meeting meeting: meetings) {
            meetingQueue.add(meeting);
        }

        int orderedMeetings [] = new int[rooms];
        for(int i=0;i<rooms;i++) {
            Meeting meeting = meetingQueue.poll();
            if(meeting== null) {
                break;
            }
            orderedMeetings[i]=meeting.getMeetingId();
        }
        return orderedMeetings;
    }

    List<Meeting> readData() {
        if(scanner == null) {
            scanner = new Scanner(System.in);
        }
        rooms = scanner.nextInt();
        int noOfMeetings = scanner.nextInt();
        List<Meeting> meetings = new ArrayList<Meeting>();
        for(int i=0; i<noOfMeetings; i++) {
            int meetingId = scanner.nextInt();
            long startTime = scanner.nextLong();
            long endTime = scanner.nextLong();
            int priority = scanner.nextInt();
            String name = scanner.next();
            Meeting meeting = new Meeting(meetingId, startTime, endTime, priority, name);
            meetings.add(meeting);
        }
        return meetings;
    }

    /*
     * This method is just for printing, not needed in production code
     */
    void printScheduledMeetings(int[] orderedMeetings) {
        if(orderedMeetings==null|| orderedMeetings.length==0) {
            System.out.println("Ordered meeting data not found");
        }
        System.out.println("Ordered meeting data:");
        for(int i=0;i<rooms;i++) {
            System.out.println("meeting_ids: " + orderedMeetings[i]);
        }
    }

    /*
     * This method is just for printing, not needed in production code
     */
    private void printInputDataBeforeOrdering(List<Meeting> meetings) {
        if(meetings == null) {
            System.out.println("Input data not found");
            return;
        }
        System.out.println("Printing input data - rooms: " + rooms + ", total number of meetings: " + meetings.size());

        for(Meeting meeting: meetings) {
            System.out.println(meeting);
        }
    }

    //junit method
    void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}
