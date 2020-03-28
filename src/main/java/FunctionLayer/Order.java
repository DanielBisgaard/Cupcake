package FunctionLayer;

import java.time.LocalDateTime;

public class Order {
    int orderID;
    int userID;
    LocalDateTime paidTime;

    public Order(int orderID, int userID, LocalDateTime paidTime) {
        this.orderID = orderID;
        this.userID = userID;
        this.paidTime = paidTime;
    }
    public Order(int userID){
    this.userID=userID;
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

    public LocalDateTime getPaidTime() {
        return paidTime;
    }

    public void setPaidTime(LocalDateTime paidTime) {
        this.paidTime = paidTime;
    }
}
