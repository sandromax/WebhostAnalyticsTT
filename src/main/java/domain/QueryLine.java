package domain;

import db.InternalDatabase;
import domain.question.Question;
import domain.question.QuestionType;
import domain.service.Service;
import domain.service.ServiceType;

import java.time.LocalDate;
import java.util.LinkedList;

public class QueryLine{

    private Service service;
    private Question question;
    private ResponseType responseType;

    private LocalDate startDate;
    private LocalDate endDate;

    public QueryLine(Service service, Question question, ResponseType responseType, LocalDate startDate) {
        this.service = service;
        this.question = question;
        this.responseType = responseType;
        this.startDate = startDate;
    }

    public QueryLine(Service service, Question question, ResponseType responseType, LocalDate startDate, LocalDate endDate) {
        this.service = service;
        this.question = question;
        this.responseType = responseType;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void execute(InternalDatabase database) {
        LinkedList<WaitingTimeline> waitingTimelines = database.getWaitingTimelines();
        int minutes = 0;
        int rows = 0;

        for(WaitingTimeline waitingTimeline : waitingTimelines) {

            if(!checkService(waitingTimeline.getService()))
                continue;

            if(!checkQuestion(waitingTimeline.getQuestion()))
                continue;

            if(!responseType.equals(waitingTimeline.getResponseType()))
                continue;

            if(!checkDates(waitingTimeline.getDate()))
                continue;

            minutes += waitingTimeline.getWaitingTime();
            rows++;

        }

        if(minutes == 0) {
            System.out.println("-");
        } else {
            System.out.println(minutes/rows);
        }

    }


    private boolean checkService(Service service) {

        if(this.service.equals(ServiceType.ALL)) {
            return true;
        }

        if(this.service.getServiceType().equals(service.getServiceType())
                && (this.service.getServiceVariation() == null)) {
            return true;
        }

        if(this.service.getServiceType().equals(service.getServiceType())
                && this.service.getServiceVariation().equals(service.getServiceVariation())) {
            return true;
        }

        return false;

    }

    private boolean checkQuestion(Question question) {
        if(this.question.getQuestionType().equals(QuestionType.ALL)) {
            return true;
        }

        if(this.question.getQuestionType().equals(question.getQuestionType())
                && this.question.getQuestionCategory() == null
                && this.question.getQuestionCategorySubcategory() == null) {

            return true;

        }

        if(this.question.getQuestionType().equals(question.getQuestionType())
                && this.question.getQuestionCategory().equals(question.getQuestionCategory())
                && this.question.getQuestionCategorySubcategory() == null) {
            return true;
        }

        if(this.question.getQuestionType().equals(question.getQuestionType())
                && this.question.getQuestionCategory().equals(question.getQuestionCategory())
                && this.question.getQuestionCategorySubcategory().equals(question.getQuestionCategorySubcategory())) {
            return true;
        }

        return false;
    }


    private boolean checkDates(LocalDate date) {

        if(endDate == null && startDate.equals(date)) {
            return true;
        } else if(endDate != null) {
            return (date.isAfter(startDate.minusDays(1)) && date.isBefore(endDate.plusDays(1)));
        }

        return false;
    }

}

