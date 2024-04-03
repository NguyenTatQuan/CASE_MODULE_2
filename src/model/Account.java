package model;

public class Account {
    private int id;
    private String username;
    private String passwork;
    private String role;

    public Account() {
    }

    public Account(int id, String username, String passwork, String role) {
        this.id = id;
        this.username = username;
        this.passwork = passwork;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", passwork='" + passwork + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
