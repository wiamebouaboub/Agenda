package agenda;

import java.time.*;

public class Event {

    /**
     * The myTitle of this event
     */
    private String myTitle;

    /**
     * The starting time of the event
     */
    protected LocalDateTime myStart;

    /**
     * The durarion of the event
     */
    private Duration myDuration;

    /**
     * Constructs an event
     *
     * @param title the title of this event
     * @param start the start time of this event
     * @param duration the duration of this event
     */
    public Event(String title, LocalDateTime start, Duration duration) {
        this.myTitle = title;
        this.myStart = start;
        this.myDuration = duration;
    }

    /**
     * Tests if an event occurs on a given day
     *
     * @param aDay the day to test
     * @return true if the event occurs on that day, false otherwise
     */
    public boolean isInDay(LocalDate aDay) {
        boolean res = false;
        LocalDate eStart = myStart.toLocalDate();
        LocalDate eEnd = myStart.plus(myDuration).toLocalDate();
        if (aDay.isAfter(eStart) || aDay.isEqual(eStart)) {
            if (aDay.isBefore(eEnd) || aDay.isEqual(eEnd)){
            res = true;
            }
        }
        return res;
    }

    /**
     * @return the myTitle
     */
    public String getTitle() {
        return myTitle;
    }

    /**
     * @return the myStart
     */
    public LocalDateTime getStart() {
        return myStart;
    }

    /**
     * @return the myDuration
     */
    public Duration getDuration() {
        return myDuration;
    }

    @Override
    public String toString() {
        return "Event{" + "myTitle=" + myTitle + ", myStart=" + myStart + ", myDuration=" + myDuration + '}';
    }
    
    

}
