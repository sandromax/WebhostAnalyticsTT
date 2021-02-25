package db;

import domain.Line;
import domain.QueryLine;
import domain.WaitingTimeline;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class InternalDatabase {

//    private LinkedList<Line> allLines;
    private LinkedList<WaitingTimeline> waitingTimelines;
//    private LinkedHashMap<Integer, QueryLine> queryLines;

    public InternalDatabase() {
//        allLines = new LinkedList<>();
        waitingTimelines = new LinkedList<>();
    }

    public void addWaitingTimeLine(WaitingTimeline waitingTimeline) {
        waitingTimelines.add(waitingTimeline);
    }

    public LinkedList<WaitingTimeline> getWaitingTimelines() {
        return waitingTimelines;
    }
}
