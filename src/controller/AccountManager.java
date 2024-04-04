package controller;

import model.Account;
import storage.IReadWriteFile;
import storage.account.ReadWriteFileAccount;


import java.util.List;

public class AccountManager {
    private static final IReadWriteFile<Account> readWriteFile = new ReadWriteFileAccount();
    private static final List<Account> accounts = readWriteFile.readFile();

    public static void addNewAccount(Account account) {
        accounts.add(account);
        readWriteFile.writeFile(accounts);
        System.out.println("Sách đã được thêm thành công.");
    }

    public static void displayAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("Không có sách nào.");
            return;
        }
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    public static void findAccount(String accountId) {
        for (Account account : accounts) {
            if (account.getAccountId().equals(accountId)) {
                System.out.println("Sách được tìm thấy: " + accountId);
                return;
            }
        }
        System.out.println("Không tìm thấy sách với mã: " + accountId);
    }

    public static void removeAccount(String accountId) {
        Account accounToRemove = null;
        for (Account account : accounts) {
            if (account.getAccountId().equals(accountId)) {
                accounToRemove = account;
                break;
            }
        }
        if (accounToRemove != null) {
            accounts.remove(accounToRemove);
            readWriteFile.writeFile(accounts);
            System.out.println("Sách đã được xóa.");
        } else {
            System.out.println("Không tìm thấy sách với mã: " + accountId);
        }
    }

    public static void editAccount(String accountId, Account updatedAccount) {
        int accountIndex = -1;
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccountId().equals(accountId)) {
                accountIndex = i;
                break;
            }
        }
        if (accountIndex != -1) {

            accounts.set(accountIndex, updatedAccount);
            readWriteFile.writeFile(accounts);
            System.out.println("Sách đã được cập nhật thành công.");
        } else {
            System.out.println("Không tìm thấy sách với mã: " + accountId);
        }
    }
}
