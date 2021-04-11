package com.epam.Homework.Stream;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.Optional;
import java.util.Set;

public class WorkWithPaths {
    public static void main(String[] args) throws IOException {

        File[] paths = File.listRoots();
        for (int i = 0; i < paths.length; i++) {
            Files.walkFileTree(Paths.get(paths[i].getPath()), Set.of(FileVisitOption.FOLLOW_LINKS), 10, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    try {
                        System.out.format(getGasps(dir) + " + %s | last modify :%s \n", dir.getFileName(), attrs.lastModifiedTime());
                        return FileVisitResult.CONTINUE;
                    } catch (UncheckedIOException e) {
                        return FileVisitResult.CONTINUE;
                    }
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    return FileVisitResult.SKIP_SUBTREE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                        throws IOException {
                    System.out.format(getGasps(file) + "    - %s | size :%s \n", file.getFileName(), attrs.size());
                    return FileVisitResult.CONTINUE;
                }
            });
        }
    }
    static String getGasps(Path currentPath) {
        String currentStringPath = currentPath.toAbsolutePath() == null ? "" : currentPath.toAbsolutePath().toString();
        long count2 = Optional.of(Arrays.stream(currentStringPath.split("[\\\\/]")).count()).orElseGet(() -> new Long(0));
        String str = "   ";
        String repeated = str.repeat((int) count2);
        return repeated;

    }
}


