package 날짜와시간;
// LocalDate : 연, 월, 일
// LocalTime : 시, 분, 초, 나노초
// LocalDateTime : 날짜와 시간 (시간대 없음)
// ZonedDateTime : 날짜 + 시간 + 시간대

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateMain {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now(); // 오늘의 날짜
        LocalTime time = LocalTime.now(); // 현재 시간
        LocalDateTime dateTime = LocalDateTime.now(); // 날짜와 시간
        ZonedDateTime zoned = ZonedDateTime.now();

        System.out.println(date);
        System.out.println(time);
        System.out.println(dateTime);
        System.out.println(zoned);

        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초");

        String result = dateTime.format(formatter);
        System.out.println(result);
    }
}
