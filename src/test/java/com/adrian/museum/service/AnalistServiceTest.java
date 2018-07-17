package com.adrian.museum.service;

import com.adrian.museum.Application;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { Application.class })
class AnalistServiceTest {

    @Autowired
    AnalistService analist;

    /**
     * Test a given list with 240 entries. The result should be 30 visitors
     */
    @Test
    void analyzeForFile1() {
        analist.start(getPath("visiting_times.txt"));
        assertTrue(analist.getMaxVisitorsNumber()== 30);
    }

    /**
     * Test a given list with 2 entries which intersect between each other. The result should be 2 visitors
     */
    @Test
    void analyzeForFile2() {
        analist.start(getPath("visiting_times2.txt"));
        assertTrue(analist.getMaxVisitorsNumber()== 2);
    }

    /**
     * Test a given list with 2 entries which do not intersect between each other.
     * The result should be 2 entries each with 1 visitor
     */
    @Test
    void analyzeForFile3() {
        analist.start(getPath("visiting_times3.txt"));
        assertTrue(analist.getMaxVisitorsNumber()== 1);
    }

    private String[] getPath(String s) {
        return new String[]{ClassLoader.getSystemResource(s).getPath()};
    }
}