package agenda;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Description : An agenda that stores events
 */
public class Agenda {
    private List<Event> theEvents= new ArrayList<Event>();
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
        List <Event> eventsInDay=new ArrayList<Event>();
        for (Event e : theEvents){
            if(e.isInDay(day)){
                eventsInDay.add(e);
            }
        }
        return eventsInDay;
    }
}
