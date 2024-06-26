package view;

import controller.MemberManager;
import model.Member;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MenuMember {
    public static void memberManagementMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n\n----------QUẢN LÝ THÀNH VIÊN-----------");
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
        String phoneMember;
        do {
            System.out.print("Nhập số điện thoại: ");
            phoneMember = scanner.nextLine();
            if (!regexPhoneNumber(phoneMember)) {
                System.err.println("Số điện thoại không hợp lệ. Vui lòng nhập lại.");
            }
        } while (!regexPhoneNumber(phoneMember));
        System.out.print("Nhập tiền đã đóng: ");
        double totalValue = scanner.nextDouble();
        scanner.nextLine();

        return new Member(membetId, name, phoneMember, totalValue);
    }

    //phương thức regex số điện thoại
    public static boolean regexPhoneNumber(String phoneMembers) {
        String regex = "^\\(?(\\d{4})\\)?[- ]?(\\d{3})[- ]?(\\d{3})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneMembers);
        return matcher.matches();
    }
}
