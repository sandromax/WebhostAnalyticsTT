import db.InternalDatabase;
import io.TXTFileReader;

import java.util.LinkedList;

public class AppRunner {
    public static void main(String[] args) {

        InternalDatabase internalDatabase = new InternalDatabase();
        TXTFileReader fileReader = new TXTFileReader();
        LinkedList<String> lines = fileReader.readInput("input.txt");

        Handler handler = new Handler(internalDatabase, lines);
        handler.handleLines();

    }

}


