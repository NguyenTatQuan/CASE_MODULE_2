package view;

import controller.BookManager;
import model.Book;

import java.util.Scanner;

public class MenuBook {
    public static void bookManagementMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n---------QUẢN LÝ SÁCH-----------");
            System.out.println("1. Thêm sách mới");
            System.out.println("2. Hiển thị tất cả sách");
            System.out.println("3. Tìm kiếm sách theo mã");
            System.out.println("4. Xóa sách theo mã");
            System.out.println("5. Sửa thông tin sách");
            System.out.println("0. Quay lại");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Book newBook = createNewBook();
                    BookManager.addNewBook(newBook);
                    break;
                case 2:
                    System.out.println("\nDanh sách sách:");
                    BookManager.displayBooks();
                    break;
                case 3:
                    System.out.print("Nhập mã sách cần tìm theo id: ");
                    String bookId = scanner.nextLine();
                    BookManager.findBook(bookId);
                    break;
                case 4:
                    System.out.println("Nhập mã sách cần xóa: ");
                    String bookIdToDelete = scanner.nextLine();
                    BookManager.removeBook(bookIdToDelete);
                    break;
                case 5:
                    System.out.print("Nhập mã sách cần sửa: ");
                    String bookIdToEdit = scanner.nextLine();
                    Book updatedBook = createNewBook();
                    BookManager.editBook(bookIdToEdit, updatedBook);
                    break;
                case 0:
                    System.out.println("Quay lại menu chính.");
                    break;
                default:
                    System.err.println("Lựa chọn không hợp lệ! Vui lòng nhập lại.");
                    break;
            }
        } while (choice != 0);
    }

    public static Book createNewBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập id: ");
        String bookId = scanner.nextLine();
        System.out.print("Nhập tên sách: ");
        String name = scanner.nextLine();
        System.out.print("Nhập giá sách: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Nhập nhà sáng tác: ");
        String manufacturer = scanner.nextLine();
        System.out.print("Nhập mô tả: ");
        String description = scanner.nextLine();

        return new Book(bookId, name, price, manufacturer, description);
    }
}
