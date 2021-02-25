import db.InternalDatabase;
import domain.QueryLine;
import domain.question.Question;
import domain.ResponseType;
import domain.service.Service;
import domain.WaitingTimeline;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.LinkedList;

public class Handler {

    private int count;
    private LinkedList<String> lines;
    private String outputString;

    private InternalDatabase database;

    public Handler(InternalDatabase database) {

        lines = new LinkedList<>();
        outputString = new String();

        this.database = database;

        readInput();
    }

    // TODO: add checking first digit and rows count
    private void readInput() {

        InputStream is = getClass().getClassLoader().getResourceAsStream("input.txt");

        try (InputStreamReader streamReader =
                     new InputStreamReader(is, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {

            String line = reader.readLine();

            count = Integer.valueOf(line);

            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
                lines.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void handleLines() {
        String firstLetter;
        for(String line : lines) {
            firstLetter = line.substring(0, 1);

            if(firstLetter.equals("C")) {
                constructAndSaveWaitingTimeLine(line);
            } else if(firstLetter.equals("D")) {
                constructAndExecuteQueryLine(line);
            } else {
                // TODO: create exception
                System.out.println("EXCEPTION!!! Wrong line!");
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

        database.addWaitingTimeLine(waitingTimeline);

        System.out.println("DB +1 and now size is: " + database.getWaitingTimelines().size());

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
            queryLine.execute(database);

        } else if(datesArr.length == 1) {
            String[] dateArr = datesArr[0].split("\\.");
            int year = Integer.valueOf(dateArr[2]);
            int month = Integer.valueOf(dateArr[1]);
            int day = Integer.valueOf(dateArr[0]);
            LocalDate date = LocalDate.of(year,month, day);

            QueryLine queryLine = new QueryLine(service, question, responseType, date);
            queryLine.execute(database);
        }

    }

}
