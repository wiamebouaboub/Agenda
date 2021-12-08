package agenda;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class EventTest {
    // November 1st, 2020
    LocalDate nov_1_2020 = LocalDate.of(2020, 11, 1);

    // November 1st, 2020, 22:30
    LocalDateTime nov_1__2020_22_30 = LocalDateTime.of(2020, 11, 1, 22, 30);

    // 120 minutes
    Duration min_120 = Duration.ofMinutes(120);

    // 89 minutes
    Duration min_89 = Duration.ofMinutes(89);

    // A simple event
    // November 1st, 2020, 22:30, 89 minutes
    Event simple = new Event("Simple event", nov_1__2020_22_30, min_89);
    
    // An event overlapping two days
    // November 1st, 2020, 22:30, 120 minutes
    Event overlapping = new Event("Overlapping event", nov_1__2020_22_30, min_120);

    @BeforeAll
    public static void setUpClass() throws Exception {
    }

    @AfterAll
    public static void tearDownClass() throws Exception {
    }

    @BeforeEach
    public void setUp() throws Exception {
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    @Test
    public void eventIsInItsStartDay() {
        assertTrue(simple.isInDay(nov_1_2020), "Un événement a lieu dans son jour de début");
        assertTrue(overlapping.isInDay(nov_1_2020), "Un événement a lieu dans son jour de début");
    }

    @Test
    public void eventIsNotInDayBefore() {
        assertFalse(simple.isInDay(nov_1_2020.minus(1, ChronoUnit.DAYS)),  "Un événement n'a pas lieu avant son jour de début");
        assertFalse(overlapping.isInDay(nov_1_2020.minus(1, ChronoUnit.DAYS)),  "Un événement n'a pas lieu avant son jour de début");
    }

    @Test
    public void overlappingEventIsInDayAfter() {
        assertFalse(simple.isInDay(nov_1_2020.plus(1, ChronoUnit.DAYS)),      "Cet événement ne déborde pas sur le jour suivant");
        assertTrue(overlapping.isInDay(nov_1_2020.plus(1, ChronoUnit.DAYS)),  "Cet événement déborde sur le jour suivant");
    }
    @Test
    public void toStringShowsEventTitle() {
        assertTrue(simple.toString().contains("Simple event"), "toString() doit montrer le titre de l'événements");
    }

    /**
     * Test of isInDay method, of class Event.
     */
    @Test
    public void testIsInDay() {
        System.out.println("isInDay");
        LocalDate aDay = null;
        Event instance = null;
        boolean expResult = false;
        boolean result = instance.isInDay(aDay);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTitle method, of class Event.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        Event instance = null;
        String expResult = "";
        String result = instance.getTitle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStart method, of class Event.
     */
    @Test
    public void testGetStart() {
        System.out.println("getStart");
        Event instance = null;
        LocalDateTime expResult = null;
        LocalDateTime result = instance.getStart();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDuration method, of class Event.
     */
    @Test
    public void testGetDuration() {
        System.out.println("getDuration");
        Event instance = null;
        Duration expResult = null;
        Duration result = instance.getDuration();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
