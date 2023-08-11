package tech.wedev.pratice;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;

public class MainTest {
    public static void main(String[] args) {
        // 获取当前日期
        LocalDate date = LocalDate.now();

        // 将日期转换成Calendar对象
        Calendar cal = Calendar.getInstance();
        cal.set(date.getYear(), date.getMonthValue() - 1, date.getDayOfMonth());

        // 获取星期几
        DayOfWeek dayOfWeek = DayOfWeek.of(cal.get(Calendar.DAY_OF_WEEK));

        // 判断是否为周末
        if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
            System.out.println("今天是周末");
        } else {
            System.out.println("今天是工作日");
        }
    }
}