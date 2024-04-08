package view;

import controller.StaffManager;
import model.Staff;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MenuStaff {
    public static void staffManagementMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n-------------QUẢN LÝ NHÂN VIÊN-------------");
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
        String phoneStaff;
        do {
            System.out.print("Nhập số điện thoại: ");
            phoneStaff = scanner.nextLine();
            if (!regexPhoneStaff(phoneStaff)) {
                System.err.println("Số điện thoại không hợp lệ. Vui lòng nhập lại.");
            }
        } while (!regexPhoneStaff(phoneStaff));
        System.out.println("Nhập số ngày làm việc: ");
        double day = scanner.nextInt();

        scanner.nextLine();


        return new Staff(staffId, name, address, phoneStaff, day);
    }

    public static boolean regexPhoneStaff(String phoneStaffs) {
        String regex = "^\\(?(\\d{4})\\)?[- ]?(\\d{3})[- ]?(\\d{3})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneStaffs);
        return matcher.matches();

    }
}
