import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import xmlwork.JAXBController;
import xmlwork.User;

import java.io.*;


@WebServlet(name = "Servlet", value = "/Servlet")
public class Servlet extends HttpServlet {
    JAXBController controller;



    @Override
    public void init() throws ServletException {
        super.init();
        controller = new JAXBController(getServletContext().getRealPath("/") + "/WEB-INF/data/users.xml");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String pass = request.getParameter("password");
        String cPass = request.getParameter("confrimPassword");
        if (pass.equals(cPass)) {
            User user = new User(login,pass);
            controller.addUser(user);
        }
        response.getWriter().println(login + " " + cPass);
        request.getSession().setAttribute("tryAutorize", 0);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session.isNew() || session.getAttribute("tryAutorize") == null)
            session.setAttribute("tryAutorize", 1);
        else {
            int tryAutorize = (Integer) session.getAttribute("tryAutorize");
            if (tryAutorize > 3) {
                resp.getWriter().println("Превышено кол-во запросов");
                return;
            } else {
                session.setAttribute("tryAutorize", tryAutorize + 1);
            }
        }
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if(controller.isUserExists(login,password))
            resp.getWriter().println("Hello, good\ncurrent  time: " + new java.util.Date() );
        else
            resp.sendRedirect("http://localhost:8080/Lab2_OOP_war/pages/login");
    }
}
