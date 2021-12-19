package agenda;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Description : An agenda that stores events
 */
public class Agenda {

    List<Event> theEvents;

    /**
     * Adds an event to this agenda
     *
     * @param e the event to add
     */
    public void addEvent(Event e) {

        theEvents.add(e);
    }

    /**
     * Computes the events that occur on a given day
     *
     * @param day the day toi test
     * @return and iteraror to the events that occur on that day
     */
    public List<Event> eventsInDay(LocalDate day) {
        List<Event> eventInDay = new ArrayList<Event>();
        for (Event e : theEvents) {
            if (e.isInDay(day)) {
                eventInDay.add(e);
            }
        }
        return eventInDay;
    }

    public List<Event> findByTitle(String title) {
        List<Event> eventsSameTitle = new ArrayList<Event>();
        for(Event e: theEvents){
            if(e.getTitle().equals(title)){
                eventsSameTitle.add(e);
            }
        }
        return eventsSameTitle;
    }
}
