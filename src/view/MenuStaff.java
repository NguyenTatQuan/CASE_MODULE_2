package view;

import controller.StaffManager;
import model.Staff;

import java.util.Scanner;

public class MenuStaff {
    public static void staffManagementMenu() {
        Scanner scanner= new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nQuản lý nhân viên:");
            System.out.println("1. Hiển thị nhân viên");
            System.out.println("2. Thêm nhân viên");
            System.out.println("3. Sửa nhân viên");
            System.out.println("4. Xóa nhân viên");
            System.out.println("5. Tìm kiếm nhân viên");
            System.out.println("0. Quay lại");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    StaffManager.displayStaffs();
                    break;
                case 2:
                    Staff newStaff = createNewStaff();
                    StaffManager.addNewStaff(newStaff);
                    break;
                case 3:
                    System.out.println("Nhập ID của nhân viên cần sửa: ");
                    String staffIdToEdit = scanner.nextLine();
                    Staff updatedStaff = createNewStaff();
                    StaffManager.editStaff(staffIdToEdit, updatedStaff);
                    break;
                case 4:
                    System.out.println("Nhập ID của nhân viên cần xóa: ");
                    String staffIdToDelete = scanner.nextLine();
                    StaffManager.removeStaff(staffIdToDelete);
                    break;
                case 5:
                    System.out.println("Nhập ID của nhân viên cần tìm: ");
                    String staffIdToFind = scanner.nextLine();
                    StaffManager.findStaff(staffIdToFind);
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

    public static Staff createNewStaff() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập ID: ");
        String staffId = scanner.nextLine();
        System.out.print("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập địa chỉ: ");
        String address = scanner.nextLine();
        System.out.print("Nhập số điện thoại: ");
        long phone = scanner.nextInt();
        System.out.println("Nhập số ngày làm việc: ");
        int day = scanner.nextInt();

        scanner.nextLine();


        return new Staff(staffId, name, address, phone,day);
    }

}
