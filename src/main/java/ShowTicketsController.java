import Model.Ticket;
import com.mysql.fabric.jdbc.FabricMySQLDriver;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class ShowTicketsController extends HttpServlet {

    public ShowTicketsController() {
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
        RequestDispatcher dispatcher = req.getRequestDispatcher("showTickets.jsp");
        String string = req.getQueryString();
        System.out.println(string);
        string = string.split("=")[1];

        String sel = "SELECT ticket.FilmId, film.FilmId, FilmName, Email, Place  " +
                " FROM film.ticket, film.film" +
                " where (Email = '" + string + "' and ticket.FilmId = film.FilmId);";

        String count = "SELECT Count(*), ticket.FilmId, film.FilmId, FilmName" +
                " FROM film.ticket, film.film" +
                " where (Email = '" + string + "' and ticket.FilmId = film.FilmId);";

        req.setAttribute("email", string);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/film", "root", "root");
            Statement statement = con.createStatement();
            System.out.println(count);
            ResultSet resultSet = statement.executeQuery(count);
            resultSet.next();
            int ticketCount = resultSet.getInt(1);
            System.out.println(sel);
            resultSet = statement.executeQuery(sel);
            Ticket[] tickets = new Ticket[ticketCount];
            for (int i = 0; i < ticketCount; i++) {
                resultSet.next();
                Ticket ticket = new Ticket();
                ticket.film = resultSet.getInt(1);
                ticket.place = resultSet.getInt("Place");
                ticket.filmname = resultSet.getString("FilmName");
                tickets[i] = ticket;

            }
            req.setAttribute("tickets", tickets);

        } catch (Exception e) {
            e.printStackTrace();
        }


        dispatcher.forward(req, resp);
    }
}


