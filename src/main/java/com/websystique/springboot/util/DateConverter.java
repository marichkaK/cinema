package com.websystique.springboot.util;

import java.time.LocalDateTime;
import java.util.Date;

public class DateConverter {

    public static Date convertToDateViaSqlTimestamp(LocalDateTime dateToConvert) {
        return java.sql.Timestamp.valueOf(dateToConvert);
    }
}
