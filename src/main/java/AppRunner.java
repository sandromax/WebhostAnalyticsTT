import db.InternalDatabase;
import domain.QueryLine;
import domain.ResponseType;
import domain.WaitingTimeline;
import domain.question.Question;
import domain.service.Service;
import domain.service.ServiceType;

import java.time.LocalDate;
import java.time.Period;

public class AppRunner {
    public static void main(String[] args) {

        InternalDatabase internalDatabase = new InternalDatabase();
        Handler handler = new Handler(internalDatabase);
        handler.handleLines();

    }

}


