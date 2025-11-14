package by.paulouskaya.task2.reader;

import by.paulouskaya.task2.exception.TextException;

public interface TextReader {
    String readFile(String path) throws TextException;
}