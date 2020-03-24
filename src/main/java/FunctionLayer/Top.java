package FunctionLayer;

public class Top {
    public Top(String ingredient, int price) {
        this.ingredient = ingredient;
        this.price = price;
    }

    private int id; // just used to demo retrieval of autogen keys in UserMapper
    private String ingredient;
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }
}
