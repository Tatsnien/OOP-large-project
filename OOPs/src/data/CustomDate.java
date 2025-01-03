package data;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class CustomDate {
    private int day;
    private int month;
    private int year;
    private int hr;
    private int min;
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
    
    public CustomDate() {
    	LocalDateTime localDate = LocalDateTime.now();
    	day = localDate.getDayOfMonth();
    	month = localDate.getMonthValue();
    	year = localDate.getYear();
    	hr = localDate.getHour();
    	min = localDate.getMinute();
    }

    public CustomDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    public CustomDate(int day, int month, int year, int hr, int min) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hr = hr;
        this.min = min;
    }
    
    public CustomDate(String date) {
    	this.day = Integer.parseInt(date.substring(0, 1));
    	this.month = Integer.parseInt(date.substring(2, 3));
    	this.year = Integer.parseInt(date.substring(4, 7));
    	this.hr = Integer.parseInt(date.substring(8, 9));
    	this.min = Integer.parseInt(date.substring(10, 11));
    }

    public CustomDate(int day, String mth, int year) {
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

    public int getHr() {
		return hr;
	}

	public int getMin() {
		return min;
	}
	
	public String timeStamp() {
		return 	formatTimeStamp(this.getDay()) + 
				formatTimeStamp(this.getMonth()) + 
				formatTimeStamp(this.getYear()) + 
				formatTimeStamp(this.getHr()) + 
				formatTimeStamp(this.getMin());
	}
	
	private String formatTimeStamp(int time) {
		String formatted = time + "";
		if (formatted.length() == 1)
			formatted = "0" + formatted;
		return formatted;
	}

	@Override
    public String toString() {
        return 	this.getDay() + "/" + 
        		this.getMonth() + "/" + 
        		this.getYear() + " " +
        		this.getHr() + ":" +
        		this.getMin();
    }
}
