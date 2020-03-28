package DBAccess;

import FunctionLayer.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.EmptyStackException;

public class CartMapper {
    public static void createProduct(Product p) throws LoginSampleException {

        try {

            //Nu checker vi om den cupcake vi prøver at lave allerede er i databasen
            Connection con = Connector.connection();
            String query = "Select ProductID from OlskerCupCakes.Product where TopID = ? and BotID = ?";
            PreparedStatement pstatement = con.prepareStatement(query);
            pstatement.setInt(1, p.getTopID());
            pstatement.setInt(2, p.getBotID());

            pstatement.executeQuery();

            ResultSet res = pstatement.executeQuery();

            //Hvis cupcaken allerede findes vil x blive over 0
            int x = 0;
            while ( res.next() ) {
                x = res.getInt("ProductID");

            }
            if(x==0){
                String SQL = "INSERT INTO OlskerCupCakes.Product (TopID, BotID) VALUES (?, ?)";
                PreparedStatement ps = con.prepareStatement(SQL);
                ps.setInt(1, p.getTopID());
                ps.setInt(2, p.getBotID());
                ps.executeUpdate();

                ResultSet ids = ps.executeQuery();
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
    public static ArrayList getOrderLines(int uID) {
        ArrayList<OrderLine> linjer = new ArrayList<OrderLine>();
        try {
            //få fat i orderID
            Connection con = Connector.connection();
            String SQL = "select * from olskercupcakes.orders where UserID=? and PaidTime is null;";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setInt(1, uID);
            ResultSet rs = ps.executeQuery();
            int orderID = 0;
            while ( rs.next() ) {
                orderID = rs.getInt("OrderID");
            }
            String query = "select * from olskercupcakes.orderproductlink where OrderID=?;";
            PreparedStatement prepst = con.prepareStatement( query );
            prepst.setInt(1, orderID);
            ResultSet result = prepst.executeQuery();
            int orderlineid = 0;
            int productid = 0;
            int count = 0;
            while ( result.next() ) {
                orderlineid = result.getInt("OrderLineID");
                productid = result.getInt("ProductID");
                count = result.getInt("Count");
                Product produkt = new Product();
                produkt = getProduct(productid);
                int pris = produkt.getPrice();
                String topingrediens = produkt.getTopIngredient();
                String bundingrediens = produkt.getBotIngredient();

                OrderLine OL = new OrderLine(orderlineid, orderID, productid, count, pris, bundingrediens, topingrediens);
                linjer.add(OL);
            }
        } catch ( ClassNotFoundException | SQLException ex ) {

        }
        return linjer;
    }
    public static int getBundID(String Bunden) throws LoginSampleException {
        //Her får vi fat i cupcake bundens ID. Vi behøver ikke at få fat i toppens ID, fordi vi har toppens ID med fra shop.jsp
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
    public static void createOrder(Order o) throws LoginSampleException {

        try {
            //Først checker vi om kunden har ordre i sin kurv, som ikke er betalt.
            Connection con = Connector.connection();
            String query = "Select OrderID from OlskerCupCakes.Product where UserID = ? and paidTime = 'null'";
            PreparedStatement pstatement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstatement.setInt(1, o.getUserID());


            pstatement.executeQuery();

            ResultSet res = pstatement.getGeneratedKeys();

            //Hvis kurven har ordre der ikke er betalt vil x blive over 0
            int x = 0;
            while ( res.next() ) {
                x = res.getInt("OrderID");

            }
            if(x==0){
                String SQL = "INSERT INTO OlskerCupCakes.Orders (UserID) VALUES (?)";
                PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, o.getUserID());

                ps.executeUpdate();

                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int OrderID = ids.getInt(1);
                o.setOrderID(OrderID);

            }
            else{

                System.out.println("Ordre linjer skal smides i den ordre kunden ikke har betalt for endnu");
            }


        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }
    public static Product getProduct(int pID) {
        Product product = new Product();
        try {
            Connection con = Connector.connection();
            String SQL = "select bot.Ingredient as BI, top.Ingredient as TI, sum(bot.Price + top.Price) as price from product join bot on product.botID=bot.botID join top on product.topID=top.topID where ProductID=?;";


            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, pID);

            ResultSet rs = ps.executeQuery();
            String TopIngredient="";
            String BotIngredient="";
            int Price = 0;
            while (rs.next()) {
                TopIngredient = rs.getString("TI");
                BotIngredient = rs.getString("BI");
                Price = rs.getInt("price");
            }
            product.setTopIngredient(TopIngredient);
            product.setBotIngredient(BotIngredient);
            product.setPrice(Price);



        } catch (ClassNotFoundException | SQLException ex) {

        }
        return product;
    }


    //select bot.Ingredient, top.Ingredient, sum(bot.Price + top.Price) as price from product join bot on product.botID=bot.botID join top on product.topID=top.topID where ProductID=3;



}
