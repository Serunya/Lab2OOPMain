import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;

@WebServlet(name = "Servlet", value = "/Servlet")
public class Servlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("user");
        String pass = request.getParameter("pass");
        String cPass = request.getParameter("cpass");
        if (pass.equals(cPass)) {
            User user = new User();
            user.setLogin(login);
            user.setPassword(pass);
            JAXBController.controller.createUser(user);
        }
        response.getWriter().println(pass + " " + cPass);
    }
}
