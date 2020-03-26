package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Product;
import FunctionLayer.Top;
import FunctionLayer.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.EmptyStackException;

public class CartMapper {
    public static void createProduct(Product p) throws LoginSampleException {

        try {
            int botID = CartMapper.getBundID(p.getBotID());
            Connection con = Connector.connection();
            String query = "Select ProductID from OlskerCupCakes.Product where TopID = ? and BotID = ?";
            PreparedStatement pstatement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstatement.setInt(1, p.getTopID());
            pstatement.setInt(2, botID);

            pstatement.executeQuery();

            ResultSet res = pstatement.getGeneratedKeys();
            int x = 0;
            while ( res.next() ) {
                x = res.getInt("ProductID");

            }
            if(x==0){
                String SQL = "INSERT INTO OlskerCupCakes.Product (TopID, BotID) VALUES (?, ?)";
                PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, p.getTopID());
                ps.setInt(2, botID);
                ps.executeUpdate();

                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int ProductID = ids.getInt(1);
                p.setProductID(ProductID);
                System.out.println("Denne cupcake er aldrig blevet bestilt før!");
            }
            else{
                System.out.println("Denne cupcake er bestilt før");
            }


        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static ArrayList getTopIngredients() {
        ArrayList<Top> topIngredients = new ArrayList<Top>();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM OlskerCupCakes.top";


            PreparedStatement ps = con.prepareStatement( SQL );


            ResultSet rs = ps.executeQuery();

            while ( rs.next() ) {
                String ingredient = rs.getString("ingredient");
                String email = rs.getString("email");
                String password = rs.getString("password");
                int price = rs.getInt("price");
                int topid = rs.getInt("topid");
                Top top = new Top(ingredient, price);
                top.setId(topid);


                topIngredients.add(top);
            }


        } catch ( ClassNotFoundException | SQLException ex ) {

        }
        return topIngredients;
    }
    public static ArrayList getBopIngredients() {
        ArrayList<Top> topIngredients = new ArrayList<Top>();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM OlskerCupCakes.bot";


            PreparedStatement ps = con.prepareStatement( SQL );


            ResultSet rs = ps.executeQuery();

            while ( rs.next() ) {
                String ingredient = rs.getString("ingredient");
                String email = rs.getString("email");
                String password = rs.getString("password");
                int price = rs.getInt("price");
                int topid = rs.getInt("topid");
                Top top = new Top(ingredient, price);
                top.setId(topid);


                topIngredients.add(top);
            }


        } catch ( ClassNotFoundException | SQLException ex ) {

        }
        return topIngredients;
    }
    public static int getBundID(String Bunden) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String query = "Select BotID from OlskerCupCakes.bot where Ingredient = ?";

            PreparedStatement ps = con.prepareStatement(query);//, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, Bunden);

            ResultSet rs = ps.executeQuery();
            int x = 0;
            while ( rs.next() ) {
                x = rs.getInt("BotID");






            }

        return x;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }

    }
    public static int getProduktID(int top, int bot) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String query = "Select ProductID from OlskerCupCakes.Product where BotID = ? and TopID = ?";

            PreparedStatement ps = con.prepareStatement(query);//, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, bot);
            ps.setInt(2, top);

            ResultSet rs = ps.executeQuery();
            int x = 0;
            while ( rs.next() ) {
                x = rs.getInt("ProductID");






            }

            return x;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }

    }
}
