package pgonzalezdesign.com.speedflatmating;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Venue {

    private String name;
    private String location;
    private Date startTime;
    private Date endTime;
    private String date;
    private String time;
    private String imageUrl;
    private String cost;

    public Venue(String name, String location, String startTime, String endTime, String image_url, String cost) {
        this.name = name;
        this.location = location;
        try {
            this.startTime = this.parseTime(startTime);
            this.endTime = this.parseTime(endTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.date = this.parseDateString();
        this.time = this.parseTimeString();
        this.imageUrl = image_url;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getCost() {
        return cost;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    private Date parseTime(String date) throws ParseException {
        Date time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .parse(date);
        return time;
    }

    private String parseDateString() {
        SimpleDateFormat day = new SimpleDateFormat("d MMMM");
        String dayString = day.format(this.getStartTime());
        return dayString;
    }

    private String parseTimeString() {
        SimpleDateFormat time = new SimpleDateFormat("h:mm");
        SimpleDateFormat timeAMPM = new SimpleDateFormat("a");
        String timeString = "" + time.format(this.getStartTime()) + " - " + time.format(this.getEndTime()) + " " + timeAMPM.format(this.getEndTime());
        return timeString;
    }
}

