import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the duration for your day");
        int hourInDay = scanner.nextInt();
        Planner planner = new Planner(hourInDay);

        while (true) {
            System.out.println("Welcome to the Weekly Planner");
            System.out.println("1. Add Event");
            System.out.println("2. Show Schedule");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addEventToPlanner(scanner, planner);
                    break;
                case 2:
                    planner.showSchedule();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addEventToPlanner(Scanner scanner, Planner planner) {
        System.out.print("Enter event name: ");
        String eventName = scanner.next();

        System.out.print("Enter event description: ");
        String eventDescription = scanner.nextLine();

        System.out.print("Enter event duration (hours): ");
        double duration = scanner.nextDouble();

        System.out.print("Enter day number");
        String day = scanner.next();

        Event event = new Event(eventName, eventDescription, day, duration);
        planner.addEvent(event);
    }
}
