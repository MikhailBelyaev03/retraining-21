package com.epam.Homework.Stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class WorkWithSausage {
    public static void main(String[] args) throws IOException {
        try {
            Files.readAllLines(Paths.get("src/main/java/com/epam/Homework/Stream/File.txt")).stream()
                    .map(decodedString -> new String(Base64.getMimeDecoder().decode(decodedString)))
                    .map(splittedString -> splittedString.split(","))
                    .map(stringForSub -> new String[]{stringForSub[0].substring(stringForSub[0].indexOf("'")+1, stringForSub[0].lastIndexOf("'")),
                            stringForSub[1].substring(stringForSub[1].indexOf("=") + 1, stringForSub[1].length()),
                            stringForSub[2].substring(stringForSub[2].indexOf("=") + 1, stringForSub[2].length())})
                    .map(sausageObj -> new Sausage(sausageObj[0], Integer.parseInt(sausageObj[1]), Long.parseLong(sausageObj[2])))
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}