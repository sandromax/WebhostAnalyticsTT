import db.InternalDatabase;

public class AppRunner {
    public static void main(String[] args) {

        InternalDatabase internalDatabase = new InternalDatabase();
        Handler handler = new Handler(internalDatabase);
        handler.handleLines();

    }

}


