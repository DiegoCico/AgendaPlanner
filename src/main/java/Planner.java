import java.util.ArrayList;

/**
 * The {@code Planner} class represents a weekly planner that allows adding, checking, and displaying events for each day of the week.
 */
public class Planner {
    // Constants representing days of the week and a special identifier for any day
    private static final int MONDAY = 0, TUESDAY = 1, WEDNESDAY = 2, THURSDAY = 3, FRIDAY = 4, SATURDAY = 5, SUNDAY = 6, ANY_DAY = 7;
    private ArrayList<ArrayList<Event>> week;
    private double[] hoursUsedPerDay = new double[7];
    private final double hourInDay;

    /**
     * Constructs a {@code Planner} with a specified number of hours per day.
     *
     * @param hourInDay the number of available hours in a day
     */
    public Planner(double hourInDay){
        this.hourInDay = hourInDay;
        week = new ArrayList<>(7);
        for (int i = 0; i < 7; i++) {
            week.add(new ArrayList<>());
        }
    }

    /**
     * Checks if an event can happen on a specified day based on the available hours.
     *
     * @param event the event to be checked
     * @return true if the event can happen, false otherwise
     */
    public boolean canItHappen(Event event){
        double hours = event.getDuration();
        int day = event.getDayNumber();

        if (day != ANY_DAY) {
            return hoursUsedPerDay[day] + hours <= hourInDay;
        } else {
            for (double usedHours : hoursUsedPerDay) {
                if (usedHours + hours <= hourInDay) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * Finds an available day for the event, if possible.
     *
     * @param event the event to be scheduled
     * @return the number of the day where the event can be scheduled, -1 if not possible
     */
    private int findAvailableDayForEvent(Event event) {
        for (int i = 0; i < week.size(); i++) {
            event.setDayNumber(i);
            if (canItHappen(event)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Attempts to add an event to the planner. If the event cannot be scheduled, prints a message indicating the reason.
     *
     * @param event the event to add
     */
    public void addEvent(Event event){
        if (event.getDayNumber() < 0 || event.getDayNumber() > SUNDAY && event.getDayNumber() != ANY_DAY) {
            System.out.println("Invalid day number.");
            return;
        }

        if(!canItHappen(event)){
            System.out.println("Sorry, the day is full or the event cannot be scheduled.");
            return;
        }

        if(event.getDayNumber() != ANY_DAY)
            week.get(event.getDayNumber()).add(event);
        else {
            int availableDay = findAvailableDayForEvent(event);
            if (availableDay != -1) {
                event.setDayNumber(availableDay);
                week.get(availableDay).add(event);
                hoursUsedPerDay[availableDay] += event.getDuration();
            } else {
                System.out.println("Sorry, no available day for the event.");
            }
        }
    }

    /**
     * Prints the weekly schedule with events.
     */
    public void showSchedule() {
        // Array of day names for display purposes
        String[] dayNames = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        System.out.println("Weekly Schedule:");
        System.out.println("-------------------------------------------------------");
        System.out.printf("%-10s | %-20s | %-15s\n", "Day", "Event Name", "Duration (hours)");
        System.out.println("-------------------------------------------------------");

        for (int i = 0; i < week.size(); i++) {
            ArrayList<Event> events = week.get(i);
            if (events.isEmpty()) {
                System.out.printf("%-10s | %-20s | %-15s\n", dayNames[i], "No Events", "");
            } else {
                for (Event event : events) {
                    System.out.printf("%-10s | %-20s | %-15.2f\n", dayNames[i], event.getTitle(), event.getDuration());
                }
            }
        }
        System.out.println("-------------------------------------------------------");
    }

}
