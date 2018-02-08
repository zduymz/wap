package edu.mum.wap.model;

import java.util.ArrayList;
import java.util.List;

public class Show {
    private String showDate;
    private String dayOfWeekLabel;
    private List<String> showTime = new ArrayList<>();

    public Show(String date, String day) {
        this.showDate = date;
        this.dayOfWeekLabel = day;
    }

    public Show(ShowDate d) {
        this.showDate = d.getShowDate();
        this.dayOfWeekLabel = d.getDayOfWeekLabel();
        this.showTime.add(d.getShowTime());
    }

    public void addTime(String time) {
        showTime.add(time);
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

    public List<String> getShowTime() {
        return showTime;
    }

    public void setShowTime(List<String> showTime) {
        this.showTime = showTime;
    }
}
