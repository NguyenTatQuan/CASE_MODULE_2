package controller;

import model.Staff;
import storage.staff.IReadWriteFileStaff;
import storage.staff.ReadWriteFileStaff;

import java.util.List;

public class StaffManager {
    private static final IReadWriteFileStaff readWriteFile = new ReadWriteFileStaff();
    private static final List<Staff> staffs = readWriteFile.readFile();

    public static void addNewStaff(Staff staff) {
        staffs.add(staff);
        readWriteFile.writeFile(staffs);
        System.out.println("Nhân viên đã được thêm thành công.");
    }

    public static void displayStaffs() {
        if (staffs.isEmpty()) {
            System.err.println("Không có nhân viên nào.");
            return;
        }
        for (Staff staff : staffs) {
            System.out.println(staff);
        }
    }

    public static void findStaff(String staffId) {
        for (Staff staff : staffs) {
            if (staff.getStaffId().equals(staffId)) {
                System.out.println("Nhân viên được tìm thấy: " + staff);
                return;
            }
        }
        System.err.println("Không tìm thấy Nhân viên với mã: " + staffId);
    }

    public static void removeStaff(String staffId) {
        Staff staffToRemove = null;
        for (Staff staff : staffs) {
            if (staff.getStaffId().equals(staffId)) {
                staffToRemove = staff;
                break;
            }
        }
        if (staffToRemove != null) {
            staffs.remove(staffToRemove);
            readWriteFile.writeFile(staffs);
            System.out.println("Nhân viên đã được xóa.");
        } else {
            System.err.println("Không tìm thấy Nhân viên với mã: " + staffId);
        }
    }

    public static void editStaff(String StaffId, Staff updatedStaff) {
        int staffIndex = -1;
        for (int i = 0; i < staffs.size(); i++) {
            if (staffs.get(i).getStaffId().equals(StaffId)) {
                staffIndex = i;
                break;
            }
        }
        if (staffIndex != -1) {

            staffs.set(staffIndex, updatedStaff);
            readWriteFile.writeFile(staffs);
            System.out.println("Nhân viên đã được cập nhật thành công.");
        } else {
            System.err.println("Không tìm thấy Nhân viên với mã: " + StaffId);
        }
    }
}
