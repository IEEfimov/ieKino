import Model.Film;
import Model.Place;
import Model.Ticket;
import com.mysql.fabric.jdbc.FabricMySQLDriver;
import com.mysql.jdbc.Driver;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.Enumeration;

public class BuyController extends HttpServlet {

    public BuyController() {
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
        RequestDispatcher dispatcher = req.getRequestDispatcher("buy.jsp");
        String string = req.getQueryString();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/film", "root", "root");
            Statement statement = con.createStatement();
            String select = "SELECT * from film WHERE Film"+string;
            ResultSet resultSet = statement.executeQuery(select);

            resultSet.next();
            Film film = new Film();
            film.id = resultSet.getInt("FilmId");
            film.name = resultSet.getString("FilmName");
            film.description = resultSet.getString("Description");
            film.age = resultSet.getString("Age");
            film.duration = resultSet.getInt("Duration");
            film.cost = resultSet.getInt("Cost");
            film.rating = resultSet.getInt("Rating");

            req.setAttribute("film", film);

            resultSet = statement.executeQuery("SELECT COUNT(*) from ticket WHERE FilmId="+film.id);
            resultSet.next();
            int ticketCount = resultSet.getInt(1);
            Ticket[] filmResult = new Ticket[ticketCount];
            String sql = "SELECT * from ticket WHERE FilmId="+film.id;
            System.out.println(sql);
            resultSet = statement.executeQuery(sql);
            for (int i = 0; i < ticketCount; i++) {
                resultSet.next();
                Ticket ticket = new Ticket();
                ticket.id = resultSet.getInt("TicketId");
                ticket.film = resultSet.getInt("FilmId");
                ticket.email = resultSet.getString("Email");
                ticket.place = resultSet.getInt("Place");
                filmResult[i] = ticket;
            }
            Place[][] places = new Place[5][10];
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 10; j++) {
                    Place temp = new Place('F',i*10+j);
                    for (int k = 0; k < filmResult.length; k++) {
                        if (filmResult[k].place == temp.num) temp.modificator='N';
                    }
                    places[i][j] = temp;
                }
            }
            req.setAttribute("places", places);

        } catch (Exception e) {
            e.printStackTrace();
        }


        dispatcher.forward(req, resp);
    }
}


