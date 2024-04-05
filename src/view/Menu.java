package view;

import facady.Facady;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {

    public static void main(String[] args) {
        Facady facady= new Facady();

        Scanner scanner=new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n---------MENU-----------");
            System.out.println("1. Quản lý sách");
            System.out.println("2. Quản lý thành viên");
            System.out.println("3. Quản lý nhân viên");
            System.out.println("4. Hiển thị toàn bộ danh sách");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    MenuBook.bookManagementMenu();
                    break;
                case 2:
                    MenuMember.memberManagementMenu();
                    break;
                case 3:
                    MenuStaff.staffManagementMenu();
                    break;
                case 4 :
                    facady.display();
                    break;
                case 0:
                    System.out.println("Kết thúc chương trình.");
                    break;
                default:
                    System.err.println("Lựa chọn không hợp lệ! Vui lòng nhập lại.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }

}
