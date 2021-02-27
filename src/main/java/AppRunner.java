import io.TXTFileReader;

import java.util.LinkedList;

public class AppRunner {
    public static void main(String[] args) {

        TXTFileReader fileReader = new TXTFileReader("input.txt");

        Handler handler = new Handler(fileReader);
        handler.handleLines();

    }

}


