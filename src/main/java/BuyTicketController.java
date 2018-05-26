import Model.Film;
import Model.Place;
import Model.Ticket;
import com.mysql.fabric.jdbc.FabricMySQLDriver;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class BuyTicketController extends HttpServlet {

    public BuyTicketController() {
        FabricMySQLDriver driver = null;
        try {
            driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("Templates/redirrect.jsp");
        String string = req.getQueryString();
        System.out.println(string);
        String[] params = string.split("&");
        for (int i = 0; i < params.length; i++) {
            params[i] = params[i].split("=")[1];
        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/film", "root", "root");
            Statement statement = con.createStatement();
            String insert = "INSERT INTO `ticket`(`FilmId`,`Email`,`Place`) " +
                    "VALUES("+params[0]+",\'"+params[2]+"\',"+params[1]+");";
            System.out.println(insert);
            boolean resultSet = statement.execute(insert,params);
//

        } catch (Exception e) {
            e.printStackTrace();
        }
        req.setAttribute("goTo", "/");

        dispatcher.forward(req, resp);
    }
}


