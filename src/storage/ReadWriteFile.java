package storage;

import model.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFile implements IReadWriteFile {
    public static final String PATHNAME = "book.txt";

    public List<Book> readFile() {
        File file = new File(PATHNAME);
        if (!file.exists()) {
            return getDefaultBooks();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Book>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
            return getDefaultBooks();
        }
    }

    public void writeFile(List<Book> books) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PATHNAME))) {
            oos.writeObject(books);
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi vào file: " + e.getMessage());
        }
    }

    private List<Book> getDefaultBooks() {
        List<Book> defaultBooks = new ArrayList<>();
        writeFile(defaultBooks);
        return defaultBooks;
    }
}