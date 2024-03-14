package unit08_Thread_IO;

// 스레드 (Thread)
// 프로그램 안의 작은 프로그램을 의미
// 1. Thread 추상 클래스 이용
class Printer extends Thread {
    int count = 0;

    @Override
    public void run() {
//        super.run(); <- 지워야 함
        // 한번만 실행되기에 무한 반복문 사용
        while (true) {
            System.out.println("Printer: " + count++);
            if (count > 10) {
                break;
            }
        }
    }
}

// 2. Runnable 인터페이스 이용
class Printer2 implements Runnable {
    int count = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("Printer2:" + count++);
            if (count > 10) {
                break;
            }
        }
    }
}

public class ex59_thread {
    public static void main(String[] args) {
        // 1. Thread 추상 클래스 이용
        Printer printer = new Printer();
        printer.start();

        // 2. Runnable 인터페이스 이용
        Printer2 printer2 = new Printer2();
        Thread t = new Thread(printer2);
        t.start();
    }
}

