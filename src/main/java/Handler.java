import domain.QueryLine;
import domain.question.Question;
import domain.ResponseType;
import domain.service.Service;
import domain.WaitingTimeline;
import io.InputReader;

import java.time.LocalDate;
import java.util.LinkedList;

public class Handler {

    private LinkedList<String> lines;
    private LinkedList<WaitingTimeline> waitingTimelines;

    public Handler(InputReader reader) {

        this.lines = reader.readInput();
        waitingTimelines = new LinkedList<>();

    }

    // TODO: add checking first digit (rows count) and row format
    public void handleLines() {

        int wrongLine = 1;
        String firstLetter;
        for(String line : lines) {
            firstLetter = line.substring(0, 1);

            if(firstLetter.equals("C")) {
                constructAndSaveWaitingTimeLine(line);
                wrongLine++;
            } else if(firstLetter.equals("D")) {
                constructAndExecuteQueryLine(line);
                wrongLine++;
            } else {
                wrongLine++;
                System.out.println("!!!Wrong params in line: " + wrongLine);
            }

        }
    }

    private void constructAndSaveWaitingTimeLine(String line) {

        String[] stringArr = line.split(" ");

        Service service = new Service(stringArr[1]);
        Question question = new Question(stringArr[2]);
        ResponseType responseType = ResponseType.valueOf(stringArr[3]);

        String[] dateArr = stringArr[4].split("\\.");
        int year = Integer.valueOf(dateArr[2]);
        int month = Integer.valueOf(dateArr[1]);
        int day = Integer.valueOf(dateArr[0]);
        LocalDate date = LocalDate.of(year,month, day);

        int time = Integer.valueOf(stringArr[5]);


        WaitingTimeline waitingTimeline = new WaitingTimeline(service, question, responseType, date, time);

        waitingTimelines.add(waitingTimeline);
    }

    private void constructAndExecuteQueryLine(String line) {

        String[] stringArr = line.split(" ");

        Service service = new Service(stringArr[1]);
        Question question = new Question(stringArr[2]);
        ResponseType responseType = ResponseType.valueOf(stringArr[3]);

        String[] datesArr = stringArr[4].split("-");

        if(datesArr.length > 1) {
            String[] dateArr = datesArr[0].split("\\.");
            int year = Integer.valueOf(dateArr[2]);
            int month = Integer.valueOf(dateArr[1]);
            int day = Integer.valueOf(dateArr[0]);
            LocalDate date1 = LocalDate.of(year,month, day);

            dateArr = datesArr[1].split("\\.");
            year = Integer.valueOf(dateArr[2]);
            month = Integer.valueOf(dateArr[1]);
            day = Integer.valueOf(dateArr[0]);
            LocalDate date2 = LocalDate.of(year,month, day);

            QueryLine queryLine = new QueryLine(service, question, responseType, date1, date2);
            queryLine.execute(waitingTimelines);

        } else if(datesArr.length == 1) {
            String[] dateArr = datesArr[0].split("\\.");
            int year = Integer.valueOf(dateArr[2]);
            int month = Integer.valueOf(dateArr[1]);
            int day = Integer.valueOf(dateArr[0]);
            LocalDate date = LocalDate.of(year,month, day);

            QueryLine queryLine = new QueryLine(service, question, responseType, date);
            queryLine.execute(waitingTimelines);
        }
    }

}
