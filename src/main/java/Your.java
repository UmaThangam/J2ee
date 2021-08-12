import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Your")
public class Your extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String source,destination;
		PrintWriter pw=response.getWriter();
		pw.println(" <h1>Train Ticket Booking Status Enquirey ... </h1>");
		pw.println("<table border='1'><th>name</th><th>From_Station</th><th>To_Station</th></tr>");
 	   try {
 		  source=request.getParameter("s");
 		 destination=request.getParameter("d");
 		   Class.forName("com.mysql.jdbc.Driver");
 		   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ticket_booking","root","");
 		   PreparedStatement st=con.prepareStatement("select * from passenger_details where from_station=? and to_station=? ");
 		   st.setString(1, source);
 		  st.setString(2, destination);
 		  ResultSet rs=st.executeQuery();
 		   while(rs.next()) {
 			   pw.print("<tr>");
 			   pw.print("<td>");
			   pw.print(rs.getString(1));
			   pw.print("</td>");
 			   pw.print("<td>");
 			   pw.print(rs.getString(2));
 			   pw.print("</td>");
 			   pw.print("<td>");
 			   pw.print(rs.getString(3));
 			   pw.print("</td>");
 			   pw.print("<tr>");
 		   }
 		 // pw.print("<br>to add <a href='Your_Ticket.html'> click here</a>");
 	   }catch(Exception e) {
 		   System.out.println(e);
 	   }
 	   pw.print("</table>");
	}
}
