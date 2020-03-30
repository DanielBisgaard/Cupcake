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
                String SQL = "INSERT INTO OlskerCupCakes.product (TopID, BotID) VALUES (?, ?)";
                PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, p.getTopID());
                ps.setInt(2, p.getBotID());
                ps.executeUpdate();


                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int ProductID = ids.getInt(1);
                p.setProductID(ProductID);
                System.out.println("Denne cupcake er aldrig blevet bestilt før!");
            }
            else{
                Connection connectionowich = Connector.connection();
                String quereee = "Select ProductID from OlskerCupCakes.product where TopID = ? and BotID = ?";
                PreparedStatement patstatement = connectionowich.prepareStatement(quereee);
                patstatement.setInt(1, p.getTopID());
                patstatement.setInt(2, p.getBotID());



                ResultSet reees = pstatement.executeQuery();
                while ( reees.next() ) {
                    p.setProductID(reees.getInt("ProductID"));
                }
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
                String ingredient = rs.getString("Ingredient");
                String email = rs.getString("Email");
                String password = rs.getString("Password");
                int price = rs.getInt("Price");
                int topid = rs.getInt("Topid");
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
            String SQL = "select * from OlskerCupCakes.orders where UserID=? and PaidTime is null;";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setInt(1, uID);
            ResultSet rs = ps.executeQuery();
            int orderID = 0;
            while ( rs.next() ) {
                orderID = rs.getInt("OrderID");
            }
            String query = "select * from OlskerCupCakes.orderproductlink where OrderID=?;";
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
                productid = produkt.getProductID();
                String topingrediens = produkt.getTopIngredient();
                String bundingrediens = produkt.getBotIngredient();

                OrderLine OL = new OrderLine();
                OL.setOrderLineID(orderlineid);
                OL.setProductID(productid);
                OL.setOrderID(orderID);
                OL.setCount(count);
                OL.setPrice(pris);
                OL.setBotIngredient(bundingrediens);
                OL.setTopIngredient(topingrediens);

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
    public static void createOrder(Order o) throws LoginSampleException, SQLException, ClassNotFoundException {

        try {
            Connection con = Connector.connection();
            String query = "Select OrderID from OlskerCupCakes.orders where UserID = ? and PaidTime is null;";
            PreparedStatement pstatement = con.prepareStatement(query);
            pstatement.setInt(1, o.getUserID());




            ResultSet res = pstatement.executeQuery();
            int orderID = 0;
            int x = 0;
            while (res.next()) {
                orderID = res.getInt("OrderID");
                x ++;
            }

            o.setOrderID(orderID);

            if(x==0){


                String SQL = "INSERT INTO OlskerCupCakes.orders (UserID) VALUES (?)";
                PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, o.getUserID());

                ps.executeUpdate();

                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int OrderID = ids.getInt(1);
                o.setOrderID(OrderID);
            }

        } catch (SQLException | ClassNotFoundException ex) {




    }


    }
    public static Product getProduct(int pID) {
        Product product = new Product();
        try {
            Connection con = Connector.connection();
            String SQL = "select bot.Ingredient as BI, top.Ingredient as TI, sum(bot.Price + top.Price) as price from product join bot on product.BotID=bot.BotID join top on product.TopID=top.TopID where ProductID=?;";


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

    public static OrderLine getOrderLine(int pID) {
        //Virker Ikke
        OrderLine OL = new OrderLine();
        try {
            Connection con = Connector.connection();
            String SQL = "select bot.Ingredient as BI, top.Ingredient as TI, sum(bot.Price + top.Price) as price, orderproductlink.Count, product.ProductID, orderproductlink.OrderLineID, orderproductlink.orderID from product join bot on product.BotID=bot.BotID join top on product.TopID=top.TopID join orderproductlink on product.ProductID = orderproductlink.ProductID where product.ProductID=?;";


            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, pID);

            ResultSet rs = ps.executeQuery();
            String TopIngredient="";
            String BotIngredient="";
            int Price = 0;
            int count = 0;
            int orderlineid = 0;
            while (rs.next()) {
                TopIngredient = rs.getString("TI");
                BotIngredient = rs.getString("BI");
                Price = rs.getInt("price");
                count = rs.getInt("Count");
                orderlineid = rs.getInt("OrderLineID");
            }
            OL.setTopIngredient(TopIngredient);
            OL.setBotIngredient(BotIngredient);
            OL.setPrice(Price);
            OL.setCount(count);
            OL.setOrderLineID(orderlineid);



        } catch (ClassNotFoundException | SQLException ex) {

        }
        return OL;
    }
    public static void createOrderLine(int count, int productID, int orderID) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO OlskerCupCakes.orderproductlink (Count, ProductID, OrderID) VALUES (?,?,?);";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, count);
            ps.setInt(2, productID);
            ps.setInt(3, orderID);

            ps.executeUpdate();



        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }
    public static void DeleteOrderLine(int orderlineid) throws LoginSampleException, SQLException, ClassNotFoundException {

        try {

            Connection con = Connector.connection();
            String query = "delete from OlskerCupCakes.orderproductlink where OrderLineID=?;";
            PreparedStatement pstatement = con.prepareStatement(query);
            pstatement.setInt(1, orderlineid);

            pstatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void setPayTime(int ordreid) {
        Order order = new Order(ordreid);
        try {
            Connection con = Connector.connection();

        String SQL = "update orders SET PaidTime = CURRENT_TIMESTAMP where OrderID = ?;";
        PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, ordreid);

        ps.executeUpdate();

            ResultSet ids = ps.getGeneratedKeys();
            ids.next();

            int time = ids.getInt(1);

// Find ud af hvordan man laver et sql timestamp til java datetime
        //order.setPaidTime(time);

        } catch (ClassNotFoundException e) {
        e.printStackTrace();
        } catch (SQLException e) {
        e.printStackTrace();
    }
    }
    public static int getOrderID(int uID) throws SQLException, ClassNotFoundException {
        Connection con = Connector.connection();
        String SQL = "select * from olskercupcakes.orders where UserID=? and PaidTime is null;";
        PreparedStatement ps = con.prepareStatement(SQL);
        ps.setInt(1, uID);
        ResultSet rs = ps.executeQuery();
        int orderID = 0;
        while (rs.next()) {
            orderID = rs.getInt("OrderID");
        }
        return orderID;
    }

    public static void DeleteOrder(int orderID) {
        try {

            Connection con = Connector.connection();
            String query = "delete from OlskerCupCakes.orders where OrderID=?;";
            PreparedStatement pstatement = con.prepareStatement(query);
            pstatement.setInt(1, orderID);

            pstatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void DeleteOrderLines(int orderid) throws LoginSampleException, SQLException, ClassNotFoundException {

        try {

            Connection con = Connector.connection();
            String query = "delete from OlskerCupCakes.orderproductlink where OrderID=?;";
            PreparedStatement pstatement = con.prepareStatement(query);
            pstatement.setInt(1, orderid);

            pstatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<OrderLine> getAllActiveOrderLines() {
        ArrayList<OrderLine> linjer = new ArrayList<OrderLine>();
        try {
            Connection con = Connector.connection();
            String query = "select orderproductlink.*, orders.* from OlskerCupCakes.orderproductlink join orders on orderproductlink.OrderID=orders.OrderID  where orders.PaidTime is null;";
            PreparedStatement prepst = con.prepareStatement( query );
            ResultSet result = prepst.executeQuery();
            int orderlineid = 0;
            int productid = 0;
            int count = 0;
            int userID = 0;
            int orderID = 0;
            while ( result.next() ) {
                orderlineid = result.getInt("OrderLineID");
                productid = result.getInt("ProductID");
                count = result.getInt("Count");
                userID = result.getInt("UserID");
                orderID = result.getInt("OrderID");
                Product produkt = new Product();
                produkt = getProduct(productid);
                int pris = produkt.getPrice();
                String topingrediens = produkt.getTopIngredient();
                String bundingrediens = produkt.getBotIngredient();


                OrderLine OL = new OrderLine();

                OL.setOrderLineID(orderlineid);
                OL.setProductID(productid);
                OL.setOrderID(orderID);
                OL.setCount(count);
                OL.setPrice(pris);
                OL.setBotIngredient(bundingrediens);
                OL.setTopIngredient(topingrediens);
                OL.setUserID(userID);

                linjer.add(OL);
            }
        } catch ( ClassNotFoundException | SQLException ex ) {

        }
        return linjer;
    }
    //select bot.Ingredient, top.Ingredient, sum(bot.Price + top.Price) as price from product join bot on product.botID=bot.botID join top on product.topID=top.topID where ProductID=3;



}

