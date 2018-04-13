import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class SortServlet extends HttpServlet { 
  protected void doGet(HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException 
  {
    // reading the user input
    String numbers= request.getParameter("numbers");    
    PrintWriter out = response.getWriter();
    out.println (
      "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN" +
          "http://www.w3.org/TR/html4/loose.dtd\">\n" +
      "<html> \n" +
        "<head> \n" +
          "<meta http-equiv=\"Content-Type\" content=\"text/html;charset=ISO-8859-1\"> \n" +
          "<title> My first jsp  </title> \n" +
        "</head> \n" +
        "<body> \n" +
          "<font size=\"10px\" color=green>" +
            "Hello World" +SortUtility.getSortedNumbers(numbers)+
          "</font> \n" +
        "</body> \n" +
      "</html>" 
    );  
  }  
}