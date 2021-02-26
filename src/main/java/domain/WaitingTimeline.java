package domain;

import domain.question.Question;
import domain.service.Service;

import java.time.LocalDate;

public class WaitingTimeline{

    private Service service;
    private Question question;
    private ResponseType responseType;
    private LocalDate date;
    private int waitingTime;

    public WaitingTimeline(Service service, Question question, ResponseType responseType, LocalDate date, int waitingTime) {
        this.service = service;
        this.question = question;
        this.responseType = responseType;
        this.date = date;
        this.waitingTime = waitingTime;
    }

    public Service getService() {
        return service;
    }

    public Question getQuestion() {
        return question;
    }

    public ResponseType getResponseType() {
        return responseType;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getWaitingTime() {
        return waitingTime;
    }
}
