package FunctionLayer;

public class Product {
    private int ProductID;
    private int BotID;
    private int TopID;
    private int Price;
    private String TopIngredient;
    private String BotIngredient;

    public Product(int productID, int botID, int topID, int price) {
        ProductID = productID;
        BotID = botID;
        TopID = topID;
        Price = price;
    }

    public Product() {

    }
    public Product(int productID) {
        ProductID = productID;
    }

    public int getProductID() {
        return ProductID;
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
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public void setProductID(int productID) {
        ProductID = productID;
    }

    public int getBotID() {
        return BotID;
    }

    public void setBotID(int botID) {
        BotID = botID;
    }

    public int getTopID() {
        return TopID;
    }

    public void setTopID(int topID) {
        TopID = topID;
    }
}
