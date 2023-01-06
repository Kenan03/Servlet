import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

public class TestingServlet extends HttpServlet {
    Notebook notebook = new Notebook();

    public void init(ServletConfig config) {
        notebook.file();
    }



    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        System.out.println();
        PrintWriter out = response.getWriter();
        if( uri.equals("/servlet/Notebook/add") ) {
            out.println("<html>\n<body>\n");
            out.println("<form method=\"GET\" action=\"/servlet/Notebook/add\">\n");
            out.println("Name: <input type=\"text\" name=\"name\">\n");
            out.println("<p>Number: <input type=\"phone\" name=\"number\"></p>\n");
            out.println("<p><input type=\"submit\" value=\"add\"></p>\n");
            out.println("\n</form>");
            System.out.println(request.getParameter("name") +"    " +request.getParameter("number"));
            notebook.add(request.getParameter("name"), request.getParameter("number"));
            out.println("<hr>");
            out.println("<p>If you wanna come in notebook: - <a href=/servlet/Notebook>notebook</a></p>\n");
//            response.sendRedirect("/servlet/Notebook/");
            out.println("</body>\n</html>");
            if(request.getParameter("name")!= null && request.getParameter("number") != null) {
                response.sendRedirect("/servlet/Notebook/");
            }

        }
        else if(uri.equals("/servlet/Notebook/reset") ) {
            out.println("<html>\n<body>\n");
            out.println("<p>Your notebook was reset.</p>\n");
            out.println("\nIf you wanna add new user: - " + "<a href=\"/servlet/Notebook/add\">add</a>");
            out.println("</body>\n</html>");
            notebook.reset();
        }
        else if(uri.equals("/servlet/Notebook/sort")) {
            out.println("<html>\n<body>\n");
            out.println("<p>Your notebook was sort for username</p>\n");
            StringBuffer sortNames = notebook.sort();
            out.println(sortNames);
            out.println("<hr>\nIf you wanna add new user: - " + "<a href=\"/servlet/Notebook/add\">add</a>");
            out.println("\n<p>If you wanna to check list: - " + "<a href=\"/servlet/Notebook\">list</a></p>");
            out.println("</body>\n</html>");
        }
        else {
            out.println("<html>\n<body>");
            //out.println("Last request URI was:" + uri);
            out.println("<p>Hello your notebook!</p> ");
            out.println(getMainPage());
            out.println("</body>\n</html>");
        }
    }

    public String getMainPage() {
        StringBuilder sb = new StringBuilder();
        StringBuffer strNames = notebook.getNamesStrings();
        sb.append(strNames).append("\n");
        sb.append("<hr>");
        sb.append("<p>"+"If you wanna reset: - " + "<a href=\"/servlet/Notebook/reset\">reset</a>" + "</p>");
        sb.append("<p>"+"If you wanna sort for username: - " + "<a href=\"/servlet/Notebook/sort\">sort</a>" + "</p>");
        sb.append("\nIf you wanna add new user: - " + "<a href=\"/servlet/Notebook/add\">add</a>");
        return sb.toString();
    }
}


