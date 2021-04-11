package com.epam.Homework.Stream;

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
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class WorkWithStream {
    public static void main(String[] args) throws IOException {
        List<String> arrayOfUIID = Stream.generate(() -> UUID.randomUUID().toString()).limit(10000).collect(Collectors.toList());
        Path path = Paths.get("src/main/java/com/epam/Homework/Stream/out.txt");
        try {
            Files.write(path, arrayOfUIID, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Function<char[], Integer> charToInt = new Function<char[], Integer>() {
            @Override
            public Integer apply(char[] chars) {
                return IntStream.range(0, chars.length)
                        .mapToObj(i -> chars[i])
                        .map(o -> Character.getNumericValue(o))
                        .reduce((left, right) -> left + right)
                        .get();
            }
        };
        Long count100Number = Files.readAllLines(Paths.get("src/main/java/com/epam/Homework/Stream/out.txt"))
                .stream()
                .map(o -> o.replaceAll("[^0-9 ]", ""))
                .map(o -> o.toCharArray())
                .map(o -> charToInt.apply(o))
                .filter(o -> o > 100)
                .count();

        NumberFormat numFormat = NumberFormat.getInstance();
        numFormat.setMinimumIntegerDigits(4);
        numFormat.setGroupingUsed(false);
        String stringForDate = numFormat.format(count100Number);
        ZoneId zoneId = ZoneId.of("America/Los_Angeles");
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        ZonedDateTime dateOfEnd = ZonedDateTime.of(LocalDateTime.now().plusMonths(Integer.parseInt(stringForDate.substring(0, 2))).plusDays(Integer.parseInt(stringForDate.substring(2, 4))), zoneId);
        System.out.println(formatter.format(dateOfEnd));

    }
}




