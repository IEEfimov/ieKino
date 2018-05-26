import Model.Review;
import Model.Ticket;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReviewController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("reviews.jsp");
        String string = req.getQueryString();
        if (string != null){
            String[] params = string.split("&");
            for (int i = 0; i < params.length; i++) {
                params[i] = params[i].split("=")[1];
            }
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/film", "root", "root");
                Statement statement = con.createStatement();
                String insert = "INSERT INTO `review`(`Name`,`Film`,`Text`) " +
                        "VALUES(\'"+params[0]+"\',\'"+params[1]+"\',\'"+params[2]+"\');";
                System.out.println(insert);
                boolean resultSet = statement.execute(insert,params);
//

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/film", "root", "root");
            Statement statement = con.createStatement();
            String count = "SELECT COUNT(*) from review";
            String sel = "SELECT * from review";

            System.out.println(count);
            ResultSet resultSet = statement.executeQuery(count);
            resultSet.next();
            int ticketCount = resultSet.getInt(1);
            System.out.println(sel);
            resultSet = statement.executeQuery(sel);
            Review[] reviews = new Review[ticketCount];
            for (int i = 0; i < ticketCount; i++) {
                resultSet.next();
                Review review = new Review();
                review.film = resultSet.getString("Film");
                review.name = resultSet.getString("Name");
                review.review = resultSet.getString("Text");
                reviews[i] = review;

            }
            req.setAttribute("reviews", reviews);


        } catch (Exception e) {
            e.printStackTrace();
        }

        dispatcher.forward(req,resp);
    }
}


