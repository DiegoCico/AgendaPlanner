public class Event {
    private String title;
    private String description;
    private String day;
    private double duration;

    public Event(String title, String description, String day, double duration){
        this.title = title;
        this.description = description;
        this.day = day;
        this.duration = duration;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getDay() {
        return day;
    }

    public int getDayNumber() {
        return switch (day.toLowerCase()) {
            case "monday" -> 0;
            case "tuesday" -> 1;
            case "wednesday" -> 2;
            case "thursday" -> 3;
            case "friday" -> 4;
            case "saturday" -> 5;
            case "sunday" -> 6;
            default -> 8;
        };
    }

    public void setDayNumber(int dayNumebr) {
         switch (dayNumebr) {
            case 0 -> day = "monday";
            case 1 -> day = "tuesday";
            case 2 -> day = "wednesday";
            case 3 -> day = "thursday";
            case 4 -> day = "friday";
            case 5 -> day = "saturday";
            case 6 -> day = "sunday";
            default -> day = "any";
        };
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
