package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;

public class TXTFileReader implements InputReader{

    @Override
    public LinkedList<String> readInput(String fileName) {
        LinkedList<String> lines = new LinkedList<>();

        InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);

        try (InputStreamReader streamReader =
                     new InputStreamReader(is, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {

            String line = reader.readLine();

            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            return lines;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
