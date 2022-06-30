package ru.spbu.arts.java.test;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class FilesCollector implements MyFileVisitor<Path>{

    private List<Path> allFiles;
    private Map<String, List<Path>> filesByExtension;

    public FilesCollector() {
        this.allFiles = new ArrayList<>();
        this.filesByExtension = new HashMap<String, List<Path>>();
    }

    public List<Path> getAllFiles() {
        return allFiles;
    }

    public  Map<String, List<Path>> getFilesByExtension() {
        return filesByExtension;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        allFiles.add(file);
        String[] nameAndEx = file.getFileName().toString().split("\\.");
        if (nameAndEx.length > 1) {
            String extension = nameAndEx[1];
            if (filesByExtension.get(extension) == null)
                filesByExtension.put(extension, new ArrayList<>());
            filesByExtension.get(extension).add(file);
            filesByExtension.get(extension).add(file);
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        allFiles.add(file);
        String[] nameAndEx = file.getFileName().toString().split("\\.");
        if (nameAndEx.length > 1) {
            String extension = nameAndEx[1];
            if (filesByExtension.get(extension) == null)
                filesByExtension.put(extension, new ArrayList<>());
            filesByExtension.get(extension).add(file);
            filesByExtension.get(extension).add(file);
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

}
