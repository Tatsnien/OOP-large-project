package data;

import java.util.HashMap;
import java.util.Map;

public class Date {
    private int day;
    private int month;
    private int year;
    private String mth;

    private static final Map<String, Integer> monthMap = new HashMap<>();

    static {
        monthMap.put("january", 1);
        monthMap.put("february", 2);
        monthMap.put("march", 3);
        monthMap.put("april", 4);
        monthMap.put("may", 5);
        monthMap.put("june", 6);
        monthMap.put("july", 7);
        monthMap.put("august", 8);
        monthMap.put("september", 9);
        monthMap.put("october", 10);
        monthMap.put("november", 11);
        monthMap.put("december", 12);
    }

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Date(int day, String mth, int year) {
        this.day = day;
        this.mth = mth;
        this.year = year;
        StringtoIntmonth(); // Call the method to convert month string to int
    }

    public void StringtoIntmonth() {
        Integer monthNumber = monthMap.get(mth.toLowerCase());
        if (monthNumber != null) {
            this.month = monthNumber; // Set the month if valid
        } else {
            throw new IllegalArgumentException("Invalid month: " + mth);
        }
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Day " + this.getDay() +
                " - Month: " + this.getMonth() +
                " - Year: " + this.getYear();
    }
}
