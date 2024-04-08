package storage.staff;

import model.Book;
import model.Staff;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFileStaff implements IReadWriteFileStaff {
    public static final String PATHNAMESTAFF = "staff.txt";

    @Override
    public List<Staff> readFile() {
        File fileStaff = new File(PATHNAMESTAFF);
        if (!fileStaff.exists()) {
            return getDefaultStaffs();
        }

        try (ObjectInputStream oisStaff = new ObjectInputStream(new FileInputStream(fileStaff))) {
            return (List<Staff>) oisStaff.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Lỗi khi đọc file: " + e.getMessage());
            return getDefaultStaffs();
        }
    }

    @Override
    public void writeFile(List<Staff> staffs) {
        try (ObjectOutputStream oosStaff = new ObjectOutputStream(new FileOutputStream(PATHNAMESTAFF))) {
            oosStaff.writeObject(staffs);
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi vào file: " + e.getMessage());
        }
    }

    private List<Staff> getDefaultStaffs() {
        return new ArrayList<>();  // Trả về danh sách sách mặc định nếu không thể đọc từ file
    }
}
