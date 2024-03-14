package unit07_Exception;

import java.io.FileWriter;
import java.io.IOException;

public class ex58_tryWithResources {
    public static void main(String[] args) {
        // try - with - resources 문: JDK7 버전 이상
        // try 문을 벗어나면 자동으로 close()을 호출해주는 구문
        // AutoCloseable 인터페이스를 구현한 메소드만 가능.
        try (FileWriter file = new FileWriter("data.txt")) {
            file.write("Hello World");
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileWriter file = null;
        try {
            file = new FileWriter("data2.txt");
            file.write("Hello Java!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                file.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
