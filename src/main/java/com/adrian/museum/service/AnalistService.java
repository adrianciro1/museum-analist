package com.adrian.museum.service;

import com.adrian.museum.model.MuseumEntry;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.adrian.museum.util.MuseumEntryUtil.*;

/**
 * Class for controlling the flow of the main functionality which is read, get max visitors per entry, filter list and print
 * Created by Adrian
 */
@Service
@Getter
public class AnalistService {

    @Autowired
    private ReaderService readerService;

    private int maxVisitorsNumber;

    /**
     * Start the process of 4 steps
     */
    public void start(String[] args) {
        //1st step
        readerService.readFile(args);

        //2nd step
        List<MuseumEntry> museumEntries = updateVisitorsPerEntry(readerService.getList());
        maxVisitorsNumber = getMaxVisitors(museumEntries);

        //3rd step
        List<MuseumEntry> finalEntries = findPeriod(createListWithMaximumVisitors(museumEntries, maxVisitorsNumber), maxVisitorsNumber);

        // 4th step
        printList(finalEntries);
    }
}
