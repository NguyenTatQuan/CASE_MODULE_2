package storage.book;

import model.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFileBook implements IReadWriteFileBook {
    public static final String PATHNAMEBOOK = "book.txt";

    @Override
    public List<Book> readFile() {
        File fileBook = new File(PATHNAMEBOOK);
        if (!fileBook.exists()) {
            return getDefaultBooks();
        }

        try (ObjectInputStream oisBook = new ObjectInputStream(new FileInputStream(fileBook))) {
            return (List<Book>) oisBook.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Lỗi khi đọc file: " + e.getMessage());
            return getDefaultBooks();
        }
    }

    @Override
    public void writeFile(List<Book> books) {
        try (ObjectOutputStream oosBook = new ObjectOutputStream(new FileOutputStream(PATHNAMEBOOK))) {
            oosBook.writeObject(books);
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi vào file: " + e.getMessage());
        }
    }

    private List<Book> getDefaultBooks() {
        return new ArrayList<>();  // Trả về danh sách sách mặc định nếu không thể đọc từ file
    }
}