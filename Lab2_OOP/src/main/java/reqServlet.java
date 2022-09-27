import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.time.LocalTime;

//task2
@WebServlet(name = "reqServlet", value = "/reqServlet")
public class reqServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer numberRequests = (Integer) session.getAttribute("requests");
        if(numberRequests == null){
            session.setAttribute("requests",0);
            numberRequests = 0;
        }
        response.getWriter().println("Session Id: " + session.getId() +
                "\nSession creation time: " + session.getCreationTime() +
                "\nData time: " + LocalTime.now() +
                "\nNumber of session requests: " + numberRequests
        );
        session.setAttribute("requests", numberRequests+1);
    }
}
