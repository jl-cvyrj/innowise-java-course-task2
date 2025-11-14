package by.paulouskaya.task2.reader.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;

import by.paulouskaya.task2.exception.TextException;
import by.paulouskaya.task2.reader.TextReader;

public class TextReaderImpl implements TextReader {

  @Override
  public String readFile(String path) throws TextException {
      try {
          Path filePath = Path.of(path);
          if (!Files.exists(filePath)) {
              throw new TextException("File not found: " + path);
          }
          
          if (!Files.isRegularFile(filePath)) {
              throw new TextException("Path is not a file: " + path);
          }
          
          if (!Files.isReadable(filePath)) {
              throw new TextException("File is not readable: " + path);
          }
          
          return Files.readString(filePath);
          
      } catch (InvalidPathException e) {
          throw new TextException("Invalid file path: " + path, e);
      } catch (IOException e) {
          throw new TextException("Error reading file: " + path, e);
      } catch (SecurityException e) {
          throw new TextException("Security violation while accessing file: " + path, e);
      }
  }
}
