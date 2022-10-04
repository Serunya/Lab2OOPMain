import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.Map;

@WebServlet(name = "PerciousMetalsPage", value = "/PerciousMetalsPage")
public class PerciousMetalsPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        response.setCharacterEncoding("windows-1251");
        StringBuilder url = new StringBuilder("http://www.cbr.ru/scripts/");
        if (type == null) {
            response.getWriter().println("noType");
            return;
        }
        if (type.equals("valute")) {
            if (request.getParameter("date_req") != null) {
                url.append("XML_daily.asp?");
                String date = request.getParameter("date_req");
                url.append("date_req" + "=" + date);
            }
            if(request.getParameter("date_req1") != null){
                url.append("XML_dynamic.asp?");
                String date1 = request.getParameter("date_req1");
                String date2 = request.getParameter("date_req2");
                String val = request.getParameter("VAL_NM_RQ");
                url.append("date_req1" + "=" + date1);
                url.append("&date_req2" + "=" + date2);
                url.append("&VAL_NM_RQ" + "=" + val);
            }
        }else if(type.equals("code")){
            url.append("XML_val.asp?d=0");
        }else{
            url.append("xml_metall.asp?");
            String date1 = request.getParameter("date_req1");
            String date2 = request.getParameter("date_req2");
            url.append("date_req1" + "=" + date1);
            url.append("&date_req2" + "=" + date2);
        }
        response.getWriter().println(url);
        HttpURLConnection con = (HttpURLConnection) new URL(url.toString()).openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "windows-1251"));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.getWriter().println(inputLine);
        }
        in.close();
    }
}
