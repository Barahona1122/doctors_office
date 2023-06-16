package com.example.demo.domain.helpers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ParseToDateAndTime {

    /**
     * @param dateAndTime
     * @return
     */
    public static LocalDateTime parseToDateAndTime(String dateAndTime) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(dateAndTime, dateTimeFormatter);
        return dateTime;
    }
}
