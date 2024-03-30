/**
 * The {@code Event} class represents an event with a title, description, day, and duration.
 */
public class Event {
    private String title;
    private String description;
    private String day;
    private double duration;

    /**
     * Constructs an {@code Event} with specified title, description, day, and duration.
     *
     * @param title       the title of the event
     * @param description the description of the event
     * @param day         the day of the week on which the event occurs
     * @param duration    the duration of the event in hours
     */
    public Event(String title, String description, String day, double duration){
        this.title = title;
        this.description = description;
        this.day = day;
        this.duration = duration;
    }

    /**
     * Returns the duration of the event.
     *
     * @return the duration of the event in hours
     */
    public double getDuration() {
        return duration;
    }

    /**
     * Sets the duration of the event.
     *
     * @param duration the duration of the event in hours
     */
    public void setDuration(double duration) {
        this.duration = duration;
    }

    /**
     * Returns the day of the week of the event as a string.
     *
     * @return the day of the week as a string
     */
    public String getDay() {
        return day;
    }

    /**
     * Returns the numeric representation of the day of the week.
     *
     * @return an integer representing the day of the week, where 0 is Monday, 1 is Tuesday, etc., and 8 represents any day
     */
    public int getDayNumber() {
        return switch (day.toLowerCase()) {
            case "monday" -> 0;
            case "tuesday" -> 1;
            case "wednesday" -> 2;
            case "thursday" -> 3;
            case "friday" -> 4;
            case "saturday" -> 5;
            case "sunday" -> 6;
            default -> 7;
        };
    }

    /**
     * Sets the day of the week for the event using a numeric value.
     *
     * @param dayNumber the numeric representation of the day of the week
     */
    public void setDayNumber(int dayNumber) {
        switch (dayNumber) {
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

    /**
     * Sets the day of the week for the event.
     *
     * @param day the day of the week as a string
     */
    public void setDay(String day) {
        this.day = day;
    }

    /**
     * Returns the description of the event.
     *
     * @return the description of the event
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the event.
     *
     * @param description the description of the event
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the title of the event.
     *
     * @return the title of the event
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the event.
     *
     * @param title the title of the event
     */
    public void setTitle(String title) {
        this.title = title;
    }
}
