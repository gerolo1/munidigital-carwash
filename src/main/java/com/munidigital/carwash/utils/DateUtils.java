package com.munidigital.carwash.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class DateUtils {

    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);

    public static LocalDateTime parse(String date) {
        return Optional.ofNullable(date)
                .map(str -> LocalDateTime.parse(str, DATE_FORMATTER))
                .orElse(null);
    }
}
