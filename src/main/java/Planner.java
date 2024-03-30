import java.util.ArrayList;

public class Planner {
    private static final int MONDAY = 0, TUESDAY = 1, WEDNESDAY = 2, THURSDAY = 3, FRIDAY = 4, SATURDAY = 5, SUNDAY = 6, ANY_DAY = 8;
    private ArrayList<ArrayList<Event>> week;
    private final double hourInDay;

    public Planner(double hourInDay){
        this.hourInDay = hourInDay;
        week = new ArrayList<>(7);
        for (int i = 0; i < 7; i++) {
            week.add(new ArrayList<>());
        }
    }

    public boolean canItHappen(Event event){
        double hours = event.getDuration();
        if(event.getDayNumber() != ANY_DAY) {
            for (int i = 0; i < week.get(event.getDayNumber()).size(); i++) {
                if (hours > hourInDay) {
                    return false;
                }
                hours += week.get(event.getDayNumber()).get(i).getDuration();
            }
            return true;
        } else {
            for (int i = 0; i < week.size(); i++) {
                for (int j =0; j<week.get(i).size(); j++) {
                    if (hours > (hourInDay * 7)) {
                        return false;
                    }
                    hours += week.get(i).get(j).getDuration();
                }
            }
            return true;
        }
    }

    public void addEvent(Event event){
        if(!canItHappen(event)){
            System.out.println("Sorry the day is full");
            return;
        }

        if(event.getDayNumber() != ANY_DAY)
            week.get(event.getDayNumber()).add(event);
        else {
            for (int i = 0; i < week.size(); i++) {
                event.setDayNumber(i);
                if (canItHappen(event)) {
                    week.get(i).add(event);
                    break;
                }
            }
        }
    }

    public void showSchedule(){
        for(int i = 0){

        }
    }

}
