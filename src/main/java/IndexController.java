import Model.Film;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class IndexController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/film", "root", "root");
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) from `film`");
            resultSet.next();
            int filmsCount = resultSet.getInt(1);
            Film[] filmResult = new Film[filmsCount];
            resultSet = statement.executeQuery("SELECT * from film");
            for (int i = 0; i < filmsCount; i++) {
                resultSet.next();
                Film film = new Film();
                film.id = resultSet.getInt("FilmId");
                film.name = resultSet.getString("FilmName");
                film.description = resultSet.getString("Description");
                film.age = resultSet.getString("Age");
                film.duration = resultSet.getInt("Duration");
                film.cost = resultSet.getInt("Cost");
                film.rating = resultSet.getInt("Rating");
                filmResult[i] = film;
            }

            req.setAttribute("films", filmResult);
        } catch (Exception e) {
            e.printStackTrace();
        }

        dispatcher.forward(req, resp);

    }
}


