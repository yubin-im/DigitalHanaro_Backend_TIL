package unit08_Thread_IO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

// 날짜 관련 클래스 (JDK 1.8 이상 지원)
// Date -> LocalDate, LocalTime, LocalDateTime

// 클래스 필드      MySQL(MariaDB)    Oracle
// String         varchar           varchar2
// int long       INT               number
// float double   FLOAT             float
// Date           DATE              date
// LocalDate      DATE              date
// LocalDateTime  DATETIME          date
public class ex65_timeAPI {
    public static void main(String[] args) {
        // LocalDate: 날짜
        LocalDate now = LocalDate.now();  // 현재 날짜 가져옴
        System.out.println(now);

        LocalDate birthday = LocalDate.of(2000, 12, 1);
        System.out.println(birthday);

        LocalDate xmas = LocalDate.parse("2023-12-25");
        System.out.println(xmas);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate xmas2 = LocalDate.parse("2023/12/25", formatter);
        System.out.println(xmas2);


        // LocalDate: 시간
        LocalTime time = LocalTime.now();
        System.out.println(time);

        // 해외 시간
        LocalTime parisTime = LocalTime.now(ZoneId.of("Europe/Paris"));
        System.out.println(parisTime);
        LocalTime seoulTime = LocalTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println(seoulTime);

        // 시간 설정하기
        LocalTime sleepTime = LocalTime.of(23, 30, 0);
        LocalTime getUpTime = sleepTime.plusHours(8);
        LocalTime inHouseTime = getUpTime.minusHours(5);


        // LocalDateTime: 날짜, 시간
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);
        System.out.println(dateTime.getYear());
        System.out.println(dateTime.getDayOfWeek());
        System.out.println(dateTime.getMonth());
        System.out.println(dateTime.getMonthValue());  // 달은 1부터 시작


        // 연습문제
        // 12월 25일에 크리스마스 이벤트를 시작한다.
        // 현재날짜 기준으로 D-Day를 출력하시오.
        // 출력 예) "크리스마스까지 D-24일입니다"
        LocalDate today = LocalDate.now();
        LocalDate xmas3 = LocalDate.parse("2024-12-25");
        int days = xmas3.getDayOfYear() - today.getDayOfYear();
        System.out.println("크리스마스까지 D-" + days + "일입니다.");
    }
}
