package FunctionLayer;

public class OrderLine {
    int userID;
    int OrderLineID;
    int OrderID;
    int ProductID;
    String TopIngredient;
    String BotIngredient;
    int price;
    int count;

    public OrderLine(int orderLineID, int orderID, int productID, int count, int price, String BotIngredient, String TopIngredient) {
        OrderLineID = orderLineID;
        OrderID = orderID;
        ProductID = productID;
        this.count = count;
        this.BotIngredient = BotIngredient;
        this.TopIngredient = TopIngredient;
        this.price = price;
    }
    public OrderLine(int orderLineID, int orderID, int productID, int count, int price, String BotIngredient, String TopIngredient, int userid) {
        OrderLineID = orderLineID;
        OrderID = orderID;
        ProductID = productID;
        this.count = count;
        this.BotIngredient = BotIngredient;
        this.TopIngredient = TopIngredient;
        this.price = price;
        userID = userid;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public OrderLine(int count, int price, String BotIngredient, String TopIngredient) {

        this.count = count;
        this.BotIngredient = BotIngredient;
        this.TopIngredient = TopIngredient;
        this.price = price;
    }
    public OrderLine( ) {

    }


    public String getTopIngredient() {
        return TopIngredient;
    }

    public void setTopIngredient(String topIngredient) {
        TopIngredient = topIngredient;
    }

    public String getBotIngredient() {
        return BotIngredient;
    }

    public void setBotIngredient(String botIngredient) {
        BotIngredient = botIngredient;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getOrderLineID() {
        return OrderLineID;
    }

    public void setOrderLineID(int orderLineID) {
        OrderLineID = orderLineID;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int orderID) {
        OrderID = orderID;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int productID) {
        ProductID = productID;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


}
