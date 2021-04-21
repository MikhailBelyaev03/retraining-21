package com.epam.Homework.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Base64;
import java.util.stream.Collectors;

public class WorkWithSausage {

    private static final Logger LOGGER = LoggerFactory.getLogger(
            WorkWithSausage.class);

    private static final String PATH_NAME = "src/main/java/com/epam/Homework/Stream/File.txt";

    public static void main(String[] args) {
        createSausages();
    }

    public static void createSausages() {
        try {
            Files.readAllLines(Paths.get(PATH_NAME)).stream()
                    .map(Base64.getMimeDecoder()::decode)
                    .map(String::new)
                    .map(line -> Arrays.stream(line.split(","))
                            .map(elem -> elem.split("=")[1]).collect(Collectors.toList()))
                    .map(Sausage::new)
                    .forEach(System.out::println);
        } catch (IOException e) {
            LOGGER.error("Failed to read file {}.", PATH_NAME);
        }
    }

}