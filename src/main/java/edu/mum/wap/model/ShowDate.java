package edu.mum.wap.model;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class ShowDate {
    private String showDate;
    private String dayOfWeekLabel;
    private String showTime;

    public ShowDate(String showDate, String dayOfWeekLabel, String showTime) {
        this.showDate = showDate;
        this.dayOfWeekLabel = dayOfWeekLabel;
        this.showTime = showTime;
    }

    public ShowDate(String showTime) {
        /*DateTimeFormatter formatter = DateTimeFormat.forPattern("EEE_mm/dd/yyyy_HH:mm");
        DateTime time = formatter.parseDateTime(showTime);
        this.dayOfWeekLabel = time.dayOfWeek().getAsString();
        this.showDate = time.dayOfYear().getAsString();
        this.showTime = time.hourOfDay().getAsString();*/
        Scanner scanner = new Scanner(showTime);
        this.dayOfWeekLabel = scanner.useDelimiter("_").next();
        this.showDate = scanner.useDelimiter("_").next();
        this.showTime = scanner.useDelimiter("_").next();
    }

    public String getShowDate() {
        return showDate;
    }

    public void setShowDate(String showDate) {
        this.showDate = showDate;
    }

    public String getDayOfWeekLabel() {
        return dayOfWeekLabel;
    }

    public void setDayOfWeekLabel(String dayOfWeekLabel) {
        this.dayOfWeekLabel = dayOfWeekLabel;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShowDate showDate1 = (ShowDate) o;
        return Objects.equals(showDate, showDate1.showDate) &&
                Objects.equals(dayOfWeekLabel, showDate1.dayOfWeekLabel) &&
                Objects.equals(showTime, showDate1.showTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(showDate, dayOfWeekLabel, showTime);
    }
}
