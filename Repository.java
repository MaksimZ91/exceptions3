package org.example;
import java.io.FileWriter;
import java.io.IOException;

public class Repository {
    public void write(String[] data) throws Exception{
        try(FileWriter fr = new FileWriter(data[0] +".txt", true)) {
            String text = String.join(" ", data);
            fr.write(text);
            fr.append("\n");
            fr.flush();
        } catch (IOException e) {
            throw new IOException(e);
        }
    }
}
