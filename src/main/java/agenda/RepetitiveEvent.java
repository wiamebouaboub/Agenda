package agenda;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 * Description : A repetitive Event
 */
public class RepetitiveEvent extends Event {

    private final ChronoUnit frequency;
    private List<LocalDate> lesExceptions = new ArrayList<LocalDate>();

    /**
     * Constructs a repetitive event
     *
     * @param title the title of this event
     * @param start the start of this event
     * @param duration myDuration in seconds
     * @param frequency one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     */
    public RepetitiveEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency) {
        super(title, start, duration);
        this.frequency = frequency;
    }

    /**
     * Adds an exception to the occurrence of this repetitive event
     *
     * @param date the event will not occur at this date
     */
    public void addException(LocalDate date) {
        lesExceptions.add(date);
    }

    /**
     *
     * @return the type of repetition
     */
    public ChronoUnit getFrequency() {
        return frequency;
    }

    public boolean isInDay(LocalDate aDay) {
        //Si le jour est une exception on retourne false
        if (lesExceptions.contains(aDay)) {
            return false;
        }
//DAYS
// True si le jour correspnd à la date de début ou s'il est après la date de début
        if (frequency == ChronoUnit.DAYS) {
            if (this.getStart().toLocalDate().equals(aDay)) {
                return true;
            }
            if (this.getStart().toLocalDate().isBefore(aDay)) {
                return true;
            }
        }

//WEEKS
//True si en ajoutant une semaine le correspond
        if (frequency == ChronoUnit.WEEKS) {
            for (int i = 0; i < 53; i++) {
                if (this.getStart().toLocalDate().plus(i, ChronoUnit.WEEKS).equals(aDay)) {
                    return true;
                }
                return false;
            }
        }
//MONTHS
//True si en ajoutant un mois le jour correspond
        if (frequency == ChronoUnit.MONTHS) {
            for (int i = 0; i < 12; i++) {
                if (this.getStart().toLocalDate().plus(i, ChronoUnit.MONTHS).equals(aDay)) {
                    return true;
                }
                return false;
            }
        }

        return this.getStart().toLocalDate().equals(aDay);

    }

}
