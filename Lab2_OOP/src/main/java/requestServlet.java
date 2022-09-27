import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Enumeration;

@WebServlet(name = "requestServlet", value = "/requestServlet")
public class requestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        pw.println("Method: GET");
        Enumeration enumParams = request.getParameterNames();
        while(enumParams.hasMoreElements()){
            String paramName = (String) enumParams.nextElement();
            pw.println(paramName + " : " + Arrays.toString(request.getParameterValues(paramName)));
        }
        pw.println("Data : " + LocalTime.now());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        pw.println("Method: POST");
        Enumeration enumParams = request.getParameterNames();
        while(enumParams.hasMoreElements()){
            String paramName = (String) enumParams.nextElement();
            pw.println(paramName + " : " + Arrays.toString(request.getParameterValues(paramName)));
        }
        pw.println("Data : " + LocalTime.now());
    }
}
