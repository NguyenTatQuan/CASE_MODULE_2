package view;

import controller.AccountManager;
import model.Account;

import java.util.Scanner;

public class MenuAccount {
    public static void accountManagerMenu(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nQuản lý tài khoản : ");
            System.out.println("1.Thêm tài khoản");
            System.out.println("2.Sửa tài khoản");
            System.out.println("3.Xóa tài khoản");
            System.out.println("4.Thoát");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    AccountManager.displayAccounts();
                    break;
                case 2:

            }

        }while (choice !=0);
    }
}
}
