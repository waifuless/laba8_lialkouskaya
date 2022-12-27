package laba8;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Printer {

    public void createFileAndWriteToIt(String data, String fileName) throws IOException {
        try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)))){
            writer.write(data);
        }
    }
}
