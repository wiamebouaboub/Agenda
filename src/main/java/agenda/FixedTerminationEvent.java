package agenda;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 * Description : A repetitive event that terminates after a given date, or after
 * a given number of occurrences
 */
public class FixedTerminationEvent extends RepetitiveEvent {

    private LocalDate terminationInclusive;
    private long numberOfOccurrences;
    private List<LocalDate> lesExceptions = new ArrayList<LocalDate>();

    /**
     * Constructs a fixed terminationInclusive event ending at a given date
     *
     * @param title the title of this event
     * @param start the start time of this event
     * @param duration the duration of this event
     * @param frequency one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     * @param terminationInclusive the date when this event ends
     */
    public FixedTerminationEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency, LocalDate terminationInclusive) {
        super(title, start, duration, frequency);
        this.terminationInclusive = terminationInclusive;
    }

    /**
     * Constructs a fixed termination event ending after a number of iterations
     *
     * @param title the title of this event
     * @param start the start time of this event
     * @param duration the duration of this event
     * @param frequency one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     * @param numberOfOccurrences the number of occurrences of this repetitive
     * event
     */
    public FixedTerminationEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency, long numberOfOccurrences) {
        super(title, start, duration, frequency);
        this.numberOfOccurrences = numberOfOccurrences;
    }

    public void addException(LocalDate date) {
        lesExceptions.add(date);
    }

    /**
     *
     * @return the termination date of this repetitive event
     */
    public LocalDate getTerminationDate() {
        if (getFrequency() == ChronoUnit.DAYS) {
            return LocalDate.from(getStart().plusDays(numberOfOccurrences - 1));
        }
        if (getFrequency() == ChronoUnit.WEEKS) {
            return LocalDate.from(getStart().plusWeeks(numberOfOccurrences - 1));
        }
        if (getFrequency() == ChronoUnit.MONTHS) {
            return LocalDate.from(getStart().plusYears(numberOfOccurrences - 1));
        }
        return exceptionFrequencyLocalDate("La fréquence doit être DAYS, WEEKS ou YEARS");

    }

    public long getNumberOfOccurrences() {
        if (getFrequency() == ChronoUnit.DAYS) {
            return ChronoUnit.DAYS.between(getStart(), terminationInclusive.atStartOfDay()) + 1;
        }
        if (getFrequency() == ChronoUnit.WEEKS) {
            return ChronoUnit.WEEKS.between(getStart(), terminationInclusive.atStartOfDay()) + 1;
        }
        if (getFrequency() == ChronoUnit.MONTHS) {
            return ChronoUnit.MONTHS.between(getStart(), terminationInclusive.atStartOfDay()) + 1;
        }
        return exceptionFrequencyLong("La fréquence doit être DAYS, WEEKS ou YEARS");

    }

    public boolean isInDay(LocalDate aDay) {
        if (aDay.isAfter(getTerminationDate())) {
            return false;
        } else {
            return super.isInDay(aDay);
        }
    }

    private LocalDate exceptionFrequencyLocalDate(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private long exceptionFrequencyLong(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
