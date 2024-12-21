package co.edu.uco.crosscutting.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Date;

public final class UtilDate {
    private static final String TIME_DEFAULT_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS";
    private static final DateTimeFormatter formatter = new DateTimeFormatterBuilder()
            .appendPattern(TIME_DEFAULT_FORMAT)
            .optionalStart()
            .appendFraction(ChronoField.MICRO_OF_SECOND, 0, 9, true)
            .optionalEnd()
            .toFormatter();
    public static final LocalDateTime TIME = LocalDateTime.now();
    public static Date getDefaultIsNull(Date value) {
        return UtilObject.getDefaultIsNull(value, new Date());
    }
    public static LocalDateTime getDefaultTime(LocalDateTime value, LocalDateTime defaultValue) {
        return UtilObject.getDefaultIsNull(value,defaultValue);
    }
    public static LocalDateTime getDefaultTimeIfNull(LocalDateTime value) {
        return getDefaultTime(value,TIME);
    }
    public static boolean isBetween(Date date, Date init, Date end) {
        return (date.after(init) && date.before(end));
    }
    public static boolean isBefore(Date compare, Date date) {
        return compare.before(date);
    }
    public static boolean isBefore(Date compare) {
        return compare.before(getLocalDataTimeADate(TIME));
    }
    public static boolean isBetweenIncludingInit(Date date, Date init, Date end) {
        return (isBetween(date, init, end) || date.equals(init));
    }
    public static boolean isBetweenIncludingEnd(Date date, Date init, Date end) {
        return (isBetween(date, init, end) || date.equals(end));
    }
    public static boolean isBetweenIncludingRanges(Date date, Date init, Date end) {
        return (isBetweenIncludingEnd(date, init, end) || isBetweenIncludingInit(date, init, end));
    }
    public static LocalDate currentDate() {
        return LocalDate.now();
    }
    public static Date getLocalDateADate(LocalDate date) {
        return Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
    public static LocalDate getDateALocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
    public static Date getLocalDataTimeADate(LocalDateTime dateTime) {
        return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
    public static LocalDateTime getDateALocalDateTime(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}