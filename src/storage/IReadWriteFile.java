package storage;

import model.Book;

import java.util.List;

public interface IReadWriteFile {
    List<Book> readFile();
    void writeFile(List<Book> books);
}