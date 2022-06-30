package ru.spbu.arts.java.test;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public interface MyFileVisitor<Path> extends FileVisitor<Path> {

    @Override
    default FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.println("Вышли из каталога " + dir);
        return FileVisitResult.CONTINUE;
    }

    @Override
    default FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println("Найден файл " + file);
        return FileVisitResult.CONTINUE;
    }

    @Override
    default FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println("Найден файл с ошибкой " + file);
        return FileVisitResult.CONTINUE;
    }

    @Override
    default FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        System.out.println("Вышли из каталога " + dir);
        return FileVisitResult.CONTINUE;
    }

}
