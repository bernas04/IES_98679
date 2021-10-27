package com.tomcat_21.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet(name = "App", urlPatterns = {"/app"})
public class App extends HttpServlet {
 
    private static final long serialVersionUID = -1915463532411657451L;
 
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException 
    {
         
        String user = request.getParameter("username");         
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        if (user == null){
            throw new NullPointerException("There is no username");
        }
        else{
            try {
                // Write some content
                out.println("<html>");
                out.println("<head>");
                out.println("<title>app</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h2>Hello " + user + "</h2>");
                out.println("<h2>The time right now is : " + new Date() + "</h2>");
                out.println("<img src=https://upload.wikimedia.org/wikipedia/en/thumb/f/f1/FC_Porto.svg/1200px-FC_Porto.svg.png>");
                out.println("</body>");
                out.println("</html>");
            } finally {
                out.close();
            }
        }
    }
}