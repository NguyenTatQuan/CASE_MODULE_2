package model;

import java.io.Serializable;

public class Member implements Serializable {
    private String MemberId;
    private String name;

    private String phone;
    private double totalValue;


    public Member() {
    }

    public Member(String memberId,String name,  String phone, double totalValue) {
        this.name = name;
        MemberId = memberId;
        this.phone = phone;
        this.totalValue = totalValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemberId() {
        return MemberId;
    }

    public void setMemberId(String memberId) {
        MemberId = memberId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    @Override
    public String toString() {
        return "Member{" +
                ", ID='" + MemberId + '\'' +
                "Tên thành viên='" + name + '\'' +
                ", Số điện thoại='" + phone + '\'' +
                ", Tiền đã đóng=" + totalValue +
                '}';
    }
}
