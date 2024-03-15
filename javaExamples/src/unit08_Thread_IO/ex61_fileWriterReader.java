package unit08_Thread_IO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ex61_fileWriterReader {
    public static void main(String[] args) {
        try (FileWriter file = new FileWriter("data.txt")) {
            file.write("안녕하세요~");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileReader file = new FileReader("data.txt")) {
            int data = 0;
            do {
                data = file.read();
                if (data != -1) {
                    System.out.print((char) data);
                }
            }
            while (data != -1); // End Of File
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}