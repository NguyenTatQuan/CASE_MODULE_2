package view;

import controller.MemberManager;
import model.Member;

import java.util.Scanner;

public class MenuMember {
   public static void memberManagementMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nQuản lý Thành viên:");
            System.out.println("1. Thêm Thành viên mới");
            System.out.println("2. Hiển thị tất cả Thành viên");
            System.out.println("3. Tìm kiếm Thành viên theo mã");
            System.out.println("4. Xóa Thành viên theo mã");
            System.out.println("5. Sửa thông tin Thành viên");
            System.out.println("0. Quay lại");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Member newMember = createNewMember();
                    MemberManager.addNewMember(newMember);
                    break;
                case 2:
                    System.out.println("\nDanh sách Thành viên:");
                    MemberManager.displayMembers();
                    break;
                case 3:
                    System.out.print("Nhập mã Thành viên cần tìm theo id: ");
                    String memberId = scanner.nextLine();
                    MemberManager.findMember(memberId);
                    break;
                case 4:
                    System.out.println("Nhập mã Thành viên cần xóa: ");
                    String memberIdToDelete = scanner.nextLine();
                    MemberManager.removeMember(memberIdToDelete);
                    break;
                case 5:
                    System.out.print("Nhập mã Thành viên cần sửa: ");
                    String bookIdToEdit = scanner.nextLine();
                    Member updatedMember = createNewMember();
                    MemberManager.editMember(bookIdToEdit, updatedMember);
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

    public static Member createNewMember() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập id: ");
        String membetId = scanner.nextLine();
        System.out.print("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập số điện thoại: ");
        String phone = scanner.nextLine();
        System.out.print("Nhập tiền đã đóng: ");
        double totalValue = scanner.nextDouble();
        scanner.nextLine();


        return new Member(membetId, name, phone,totalValue);
    }
}
