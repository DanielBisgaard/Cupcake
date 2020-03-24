package DBAccess;

import FunctionLayer.Top;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class IngredientMapper {
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
}
