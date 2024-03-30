import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EventTest {

    @Test
    void testEventCreation() {
        Event event = new Event("Meeting", "Project discussion", "Monday", 2.0);
        assertEquals("Meeting", event.getTitle());
        assertEquals("Project discussion", event.getDescription());
        assertEquals("Monday", event.getDay());
        assertEquals(2.0, event.getDuration());
    }

    @Test
    void testDayNumberConversion() {
        Event event = new Event("Workout", "Gym session", "Tuesday", 1.0);
        assertEquals(1, event.getDayNumber());
    }

    @Test
    void testSetDayNumber() {
        Event event = new Event("Yoga", "Morning routine", "any", 1.5);
        event.setDayNumber(4);
        assertEquals("friday", event.getDay());
    }
}
