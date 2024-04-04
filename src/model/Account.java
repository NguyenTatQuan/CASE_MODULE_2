package model;

public class Account {
    private String accountId;
    private String username;
    private String passwork;
    private String role;

    public Account() {
    }

    public Account(String accountId, String username, String passwork, String role) {
        this.accountId = accountId;
        this.username = username;
        this.passwork = passwork;
        this.role = role;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
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
                "accountId='" + accountId + '\'' +
                ", username='" + username + '\'' +
                ", passwork='" + passwork + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
