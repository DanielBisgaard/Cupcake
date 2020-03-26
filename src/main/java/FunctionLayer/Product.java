package FunctionLayer;

public class Product {
    private int ProductID;
    private String BotID;
    private int TopID;

    public Product(int productID, String botID, int topID) {
        ProductID = productID;
        BotID = botID;
        TopID = topID;
    }

    public Product() {

    }
    public Product(int productID) {
        ProductID = productID;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int productID) {
        ProductID = productID;
    }

    public String getBotID() {
        return BotID;
    }

    public void setBotID(String botID) {
        BotID = botID;
    }

    public int getTopID() {
        return TopID;
    }

    public void setTopID(int topID) {
        TopID = topID;
    }
}
