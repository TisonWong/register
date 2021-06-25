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
        LocalTime nowTime = LocalTime.now();
        LocalDate nowDate = LocalDate.now();
        int hour = nowTime.get(ChronoField.HOUR_OF_DAY);
        LocalDate nextDay;
        if(hour<5){
            nextDay = nowDate;
        }else{
            nextDay = nowDate.plusDays(1);
        }
        return nextDay;
    }

    public Map<String, LocalDateTime> getQueryDate(){
        Map<String,LocalDateTime> dateTimeMap = new HashMap<>();

        LocalDate nowDate = LocalDate.now();
        LocalDateTime yesterdayDateTime = LocalDateTime.of(LocalDate.now(),LocalTime.of(5,0,0));

        LocalDate today = nowDate.plusDays(1);
        LocalDateTime todayDateTime = LocalDateTime.of(today,LocalTime.of(5,0,0));

        dateTimeMap.put("startDate",yesterdayDateTime);
        dateTimeMap.put("endDate",todayDateTime);
        System.err.println(yesterdayDateTime+"~"+todayDateTime);

        return dateTimeMap;
    }

}
