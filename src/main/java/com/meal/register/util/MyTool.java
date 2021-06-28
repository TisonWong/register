package com.meal.register.util;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.util.HashMap;
import java.util.Map;

@Component
public class MyTool {

    public LocalDate getNextDay(){
        LocalDate nowDate = LocalDate.now();
        return nowDate.plusDays(1);
    }

    public Map<String, LocalDateTime> getQueryDate(){
        Map<String,LocalDateTime> dateTimeMap = new HashMap<>();

        LocalDate today = LocalDate.now();
        LocalDateTime todayDateTime = LocalDateTime.of(today,LocalTime.of(0,0,0));
        LocalDateTime tomorrowDateTime = LocalDateTime.of(today,LocalTime.of(23,59,0));

        dateTimeMap.put("startDate",todayDateTime);
        dateTimeMap.put("endDate",tomorrowDateTime);

        return dateTimeMap;
    }

}
