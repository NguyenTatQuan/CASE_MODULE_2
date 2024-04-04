package controller;

import model.Book;
import storage.IReadWriteFile;
import storage.book.ReadWriteFileBook;

import java.util.List;

public class BookManager {

    private static final IReadWriteFile<Book> readWriteFile = new ReadWriteFileBook();
    private static final List<Book> books = readWriteFile.readFile();

    public static void addNewBook(Book book) {
        books.add(book);
        readWriteFile.writeFile(books);
        System.out.println("Sách đã được thêm thành công.");
    }

    public static void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("Không có sách nào.");
            return;
        }
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public static void findBook(String bookId) {
        for (Book book : books) {
            if (book.getBookId().equals(bookId)) {
                System.out.println("Sách được tìm thấy: " + book);
                return;
            }
        }
        System.out.println("Không tìm thấy sách với mã: " + bookId);
    }

    public static void removeBook(String bookId) {
        Book bookToRemove = null;
        for (Book book : books) {
            if (book.getBookId().equals(bookId)) {
                bookToRemove = book;
                break;
            }
        }
        if (bookToRemove != null) {
            books.remove(bookToRemove);
            readWriteFile.writeFile(books);
            System.out.println("Sách đã được xóa.");
        } else {
            System.out.println("Không tìm thấy sách với mã: " + bookId);
        }
    }

    public static void editBook(String BookId, Book updatedBook) {
        int bookIndex = -1;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getBookId().equals(BookId)) {
                bookIndex = i;
                break;
            }
        }
        if (bookIndex != -1) {

            books.set(bookIndex, updatedBook);
            readWriteFile.writeFile(books);
            System.out.println("Sách đã được cập nhật thành công.");
        } else {
            System.out.println("Không tìm thấy sách với mã: " + BookId);
        }
    }


}
