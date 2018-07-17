package com.adrian.museum.service;

import com.adrian.museum.model.MuseumEntry;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Class for reading a txt file with the pairs of museum entries and create a list museumEntries
 * Created by Adrian
 */
@Service
public class ReaderService {

    private ArrayList<MuseumEntry> museumEntries;

    public static final String VISITING_TIMES_FILE_NAME = "visiting_times.txt";
    private static final boolean IS_WINDOWS = System.getProperty("os.name").contains("Windows");

    public List<MuseumEntry> getList() {
        return museumEntries;
    }

    /**
     * Read the content of a file and create a MuseumEntry list
     * If filename is given, the application will try to load the file from the absolute path
     * If filename is empty, will load the file from resources
     * @param filename
     */
    public void readFile(String... filename) {

        museumEntries = new ArrayList<MuseumEntry>();
        String path;

        if (filename.length > 0) {
            File newFile = new File(filename[0]);
            path = newFile.getPath();
        } else {
            path = ClassLoader.getSystemResource(VISITING_TIMES_FILE_NAME).getPath();
        }
        String osAppropriatePath = IS_WINDOWS ? path.substring(1) : path;

        try (Stream<String> stream = Files.lines(Paths.get(osAppropriatePath))) {

            stream.forEach(a -> {
                museumEntries.add(new MuseumEntry(LocalTime.parse(a.split(",")[0]), LocalTime.parse(a.split(",")[1])));
            });

        } catch (IOException e) {
            System.out.println("Error while loading the file. Please try again");
        }
    }

}
