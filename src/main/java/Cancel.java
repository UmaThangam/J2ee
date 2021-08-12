

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Cancel
 */
@WebServlet("/Cancel")
public class Cancel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String journey_date,name;
		PrintWriter pw=response.getWriter();
		try {
			name=request.getParameter("n");
			journey_date=request.getParameter("d");
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ticket_booking","root","");
			PreparedStatement ps=con.prepareStatement("delete from passenger_details where name= ? and journey_date=?");
			ps.setString(1, name);
			ps.setString(2, journey_date);
			ps.executeUpdate();
			pw.print("Ticket Cancelled<br>");
			pw.print("to add <a href='Cancel_Ticket.html'> click here</a>");
		}catch(Exception e) {
			pw.println(e);
		}
		
	}

}
