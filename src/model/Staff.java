package model;

import java.io.Serializable;

public class Staff implements SalaryStaff, Serializable {
    private String staffId;
    private String name;
    private String address;
    private String phone;
    private double day;

    public Staff() {
    }

    public Staff(String staffId, String name, String address, String phone, double day) {
        this.staffId = staffId;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.day = day;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public double getSalary() {
        double salary = 200;
        return salary;
    }

    @Override
    public double salaryStaff() {
        return getSalary()*getDay();
    }

    @Override
    public String toString() {
        return "staff{" +
                "ID=" + staffId +
                ", Tên nhân viên='" + name + '\'' +
                ", Địa chỉ='" + address + '\'' +
                ", Số điện thoại=" + phone +
                ", Lương=" + salaryStaff() +
                '}';
    }
}