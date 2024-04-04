package view;

import controller.BookManager;
import model.Book;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Thêm sách mới");
            System.out.println("2. Hiển thị tất cả sách");
            System.out.println("3. Tìm kiếm sách theo mã");
            System.out.println("4. Xóa sách theo mã");
            System.out.println("5. Sửa thông tin sách");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    Book newBook = createNew(scanner);
                    BookManager.addNewBook(newBook);
                    break;
                case 2:
                    System.out.println("\nDanh sách sách:");
                    BookManager.displayBookts();
                    break;
                case 3:
                    System.out.print("Nhập mã sách cần tìm theo id: ");
                    String bookId = scanner.nextLine();
                    BookManager.findBook(bookId);
                    break;
                case 4:
                    System.out.println("Nhập mã sách cần xóa: ");
                    String bookId1 = scanner.nextLine();
                    BookManager.removeBook(bookId1);
                    break;
                case 5:
                    System.out.print("Nhập mã sách cần sửa: ");
                    String bookIdToEdit = scanner.nextLine();
                    Book updatedBook = createNew(scanner);
                    BookManager.editBook(bookIdToEdit, updatedBook);
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.err.println("Lựa chọn không hợp lệ! Vui lòng nhập lại.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }

    public static Book createNew(Scanner scanner) {
        System.out.print("Nhập id: ");
        String bookId = scanner.nextLine();
        System.out.print("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập giá: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Nhập hãng: ");
        String manufacturer = scanner.nextLine();
        System.out.print("Nhập mô tả: ");
        String description = scanner.nextLine();

        return new Book(bookId, name, price, manufacturer, description);
    }
}
