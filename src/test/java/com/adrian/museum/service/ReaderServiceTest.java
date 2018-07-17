package com.adrian.museum.service;

import com.adrian.museum.Application;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { Application.class })
class ReaderServiceTest {

    @Autowired
    ReaderService readerService;

    @Test
    public void readFilePassingEmptyFilename() {
        readerService.readFile();
        assertFalse(readerService.getList().isEmpty());
    }

    @Test
    public void readFilePassingWrongFilename() {
        readerService.readFile("visiting_times.txt");
        assertTrue(readerService.getList().isEmpty());
    }
}