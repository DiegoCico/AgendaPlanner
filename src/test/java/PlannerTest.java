import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlannerTest {

    private Planner planner;

    @BeforeEach
    void setUp() {
        planner = new Planner(8.0); // assuming an 8-hour day for testing
    }

    @Test
    void testAddEvent() {
        Event meeting = new Event("Meeting", "Team meeting", "Monday", 2.0);
        planner.addEvent(meeting);
        assertTrue(planner.canItHappen(meeting));
    }

    @Test
    void testEventOverlaps() {
        Event longMeeting = new Event("Long Meeting", "Extended discussion", "Tuesday", 9.0);
        assertFalse(planner.canItHappen(longMeeting));
    }

    @Test
    void testAddEventOnAnyDay() {
        Event flexibleEvent = new Event("Flex Event", "Flexible schedule", "any", 3.0);
        planner.addEvent(flexibleEvent);
        int expectedDay = flexibleEvent.getDayNumber();
        assertTrue(expectedDay >= 0 && expectedDay <= 6); // Should be scheduled on any day from Monday to Sunday
    }
}
