package model;

public class Account {
    private String username;
    private String passwork;
    private String role;
    private String staff;

    public Account() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswork() {
        return passwork;
    }

    public void setPasswork(String passwork) {
        this.passwork = passwork;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStaff() {
        return staff;
    }

    public void setStaff(String staff) {
        this.staff = staff;
    }

    public Account(String username, String passwork, String role, String staff) {
        this.username = username;
        this.passwork = passwork;
        this.role = role;
        this.staff = staff;

    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", passwork='" + passwork + '\'' +
                ", role='" + role + '\'' +
                ", staff='" + staff + '\'' +
                '}';
    }
}
