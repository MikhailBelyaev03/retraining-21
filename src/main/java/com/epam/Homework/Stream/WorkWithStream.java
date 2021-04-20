package com.epam.Homework.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.stream.Stream.generate;

public class WorkWithStream {

    private static final Logger LOGGER = LoggerFactory.getLogger(
            WorkWithStream.class);

    private static final String PATH_NAME = "src/main/java/com/epam/Homework/Stream/out.txt";

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_DATE_TIME;

    public static void main(String[] args) {

        List<String> arrayOfUIID = getListOfUUID();

        Path path = Optional.of(Paths.get(PATH_NAME)).orElse(Paths.get(System.getProperty("user.dir")));
        try {
            Files.write(path, arrayOfUIID, StandardCharsets.UTF_8);
        } catch (IOException e) {
            LOGGER.error("Failed to read file {}.", path);
        }

        Long count100Number = getCountOfNumbersUUID();
        getTheEndOfTheWorldDate(count100Number);

    }

    public static List<String> getListOfUUID() {
        return generate(UUID::randomUUID)
                .map(Objects::toString)
                .limit(10000)
                .collect(Collectors.toList());
    }

    public static Long getCountOfNumbersUUID() {
        try {
            return Files.lines(Paths.get(PATH_NAME))
                    .filter(Objects::nonNull)
                    .map(x -> x.replaceAll("\\D", ""))
                    .map(x -> x.chars().map(Character::getNumericValue).sum())
                    .filter(sum -> sum > 100)
                    .count();
        } catch (IOException e) {
            LOGGER.error("Failed to read file {}.", PATH_NAME);
        }
        return null;
    }

    public static void getTheEndOfTheWorldDate(Long count100Number) {
        NumberFormat numFormat = NumberFormat.getInstance();
        numFormat.setMinimumIntegerDigits(4);
        numFormat.setGroupingUsed(false);
        String stringForDate = numFormat.format(count100Number);
        ZoneId zoneId = ZoneId.of("America/Los_Angeles");
        String monthOfTheEndOfTheWorld = stringForDate.substring(0, 2);
        String yearOfTheEndOfTheWorld = stringForDate.substring(2, 4);
        ZonedDateTime dateOfEnd = ZonedDateTime.of(LocalDateTime.now()
                .plusMonths(Integer.parseInt(monthOfTheEndOfTheWorld))
                .plusDays(Integer.parseInt(yearOfTheEndOfTheWorld)), zoneId);
        LOGGER.info(FORMATTER.format(dateOfEnd));
    }
}




