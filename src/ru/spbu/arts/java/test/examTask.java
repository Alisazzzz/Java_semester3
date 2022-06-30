package ru.spbu.arts.java.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class examTask {

    public static void main(String[] args) throws IOException {

        Path path = Path.of("D:/Вычислительные системы");

        //Часть 1: реализация интерфейса FileVisitor
        MyFileVisitor<Path> fileVisitor = new MyFileVisitor<Path>() {};
        Files.walkFileTree(path, fileVisitor);

        //Часть 2: класс FilesCollector
        FilesCollector fc = new FilesCollector();
        Files.walkFileTree(path, fc);
        List<Path> allFiles = fc.getAllFiles();
        System.out.println(allFiles);

        //Часть 3: getFilesByExtension
        Map<String, List<Path>> filesByExtension = fc.getFilesByExtension();
        for (String key: filesByExtension.keySet()) {
            System.out.println(filesByExtension.get(key).size());
        }

    }
}
