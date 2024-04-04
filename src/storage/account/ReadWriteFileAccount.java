package storage.account;

import model.Account;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFileAccount implements IReadWriteFileAccount{
    public static final String PATHNAMEACCOUNT = "account.txt";

    @Override
    public List<Account> readFile() {
        File fileAccount = new File(PATHNAMEACCOUNT);
        if (!fileAccount.exists()) {
            return getDefaultAccounts();
        }

        try (ObjectInputStream oisAccount = new ObjectInputStream(new FileInputStream(fileAccount))) {
            return (List<Account>) oisAccount.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Lỗi khi đọc file: " + e.getMessage());
            return getDefaultAccounts();
        }
    }

    @Override
    public void writeFile(List<Account> accounts) {
        try (ObjectOutputStream oosAccount = new ObjectOutputStream(new FileOutputStream(PATHNAMEACCOUNT))) {
            oosAccount.writeObject(accounts);
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi vào file: " + e.getMessage());
        }
    }

    private List<Account> getDefaultAccounts() {
        return new ArrayList<>();
    }
}
