package FunctionLayer;

import java.time.LocalDateTime;
import java.util.Date;

public class Order_User {
    private int orderID;
    private int userID;
    private Date paidTime;

    private String email;
    private String password;
    private String role;
    private int credit;

    public Order_User(int orderID, int userID, Date paidTime, String email, String password, String role, int credit) {
        this.orderID = orderID;
        this.userID = userID;
        this.paidTime = paidTime;
        this.email = email;
        this.password = password;
        this.role = role;
        this.credit = credit;
    }
    public Order_User(int orderID, int userID, String email, String password, String role, int credit) {
        this.orderID = orderID;
        this.userID = userID;
        this.email = email;
        this.password = password;
        this.role = role;
        this.credit = credit;
    }
    public Order_User() {

    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Date getPaidTime() {
        return paidTime;
    }

    public void setPaidTime(Date paidTime) {
        this.paidTime = paidTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
}
