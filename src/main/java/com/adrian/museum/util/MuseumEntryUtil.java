package com.adrian.museum.util;

import com.adrian.museum.model.MuseumEntry;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Util class containing methods to filter lists or find specific information on those lists
 * Created by Adrian
 */
public class MuseumEntryUtil {


    static Comparator<MuseumEntry> isBeforeArrivalComparator = (m1, m2) -> {
        return m1.getArrivalTime().isBefore(m2.getArrivalTime()) ? -1 : 1;
    };

    static Comparator<MuseumEntry> isAfterArrivalComparator = (m1, m2) -> {
        return m1.getArrivalTime().isAfter(m2.getArrivalTime()) ? -1 : 1;
    };


    /**
     * Method to update each entry number of visitors making a loop against the other entries and assuring
     * that it counts the other entries which are within the range
     *
     * @param museumEntries
     * @return
     */
    public static List<MuseumEntry> updateVisitorsPerEntry(List<MuseumEntry> museumEntries) {

        museumEntries.stream().forEach(m1 -> m1.setVisitorsDuringPeriod(
                ((int) museumEntries.stream().filter(m2 -> (isEntryInsideRange(m2.getArrivalTime(), m1.getArrivalTime(), m1.getLeavingTime())
                        || isEntryInsideRange(m2.getLeavingTime(), m1.getArrivalTime(), m1.getLeavingTime()))
                        && !m1.equals(m2))
                        .count()) + 1));

        return museumEntries;
    }

    /**
     * Get the max number of visitors in the list
     *
     * @param museumEntries
     * @return
     */
    public static int getMaxVisitors(List<MuseumEntry> museumEntries) {
        return museumEntries.stream().mapToInt(MuseumEntry::getVisitorsDuringPeriod).max().getAsInt();
    }

    /**
     * Get a list where VisitorsDuringPeriod is equal to the visitors param given
     *
     * @param museumEntries
     * @param visitors
     * @return
     */
    public static List<MuseumEntry> createListWithMaximumVisitors(List<MuseumEntry> museumEntries, int visitors) {
        return museumEntries.stream().filter(museumEntry -> museumEntry.getVisitorsDuringPeriod() == visitors).collect(Collectors.toList());
    }

    /**
     * Find the intersection dates between the given list. If the list has only one entry or if it is empty, return the same list.
     * If has 2 or more entries, sort the list to find the greater arrival time and the lesser leaving time. If there are periods which do not intersect
     * between each other, return initial list
     * @param museumEntries
     * @param visitors
     * @return
     */
     public static List<MuseumEntry> findPeriod(List<MuseumEntry> museumEntries, int visitors) {

        List<MuseumEntry> finalEntry = new ArrayList<>();

        if(museumEntries.size() == 1){
            return museumEntries;
        }

        if (!museumEntries.isEmpty()) {
            LocalTime startTime = museumEntries.stream().sorted(isAfterArrivalComparator).findFirst().get().getArrivalTime();
            LocalTime finalTime = museumEntries.stream().sorted(isBeforeArrivalComparator).findFirst().get().getLeavingTime();

            if(startTime.isBefore(finalTime)){
                MuseumEntry museumEntry = new MuseumEntry(startTime, finalTime);
                museumEntry.setVisitorsDuringPeriod(visitors);
                finalEntry.add(museumEntry);
                return finalEntry;
            }
        }

        return museumEntries;
    }

    /**
     * For a given list, print its content
     *
     * @param museumEntries
     */
    public static void printList(List<MuseumEntry> museumEntries) {
        museumEntries.stream().forEach(System.out::println);
    }

    private static boolean isEntryInsideRange(LocalTime time, LocalTime time1Arriving, LocalTime time1Leaving) {
        return time.isAfter(time1Arriving) && time.isBefore(time1Leaving);
    }
}
