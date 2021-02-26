package db;

import domain.WaitingTimeline;

import java.util.LinkedList;

public class InternalDatabase {

    private LinkedList<WaitingTimeline> waitingTimelines;

    public InternalDatabase() {
        waitingTimelines = new LinkedList<>();
    }

    public void addWaitingTimeLine(WaitingTimeline waitingTimeline) {
        waitingTimelines.add(waitingTimeline);
    }

    public LinkedList<WaitingTimeline> getWaitingTimelines() {
        return waitingTimelines;
    }
}
