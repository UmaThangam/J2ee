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
@WebServlet("/myservlet")
public class myservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int ticket=500;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name,sex,train_name, from,to,date,quata,berth_choice,class_type,phno;
		int age;
		PrintWriter p=response.getWriter();
		try {
		name=request.getParameter("n");
		from=request.getParameter("f");
		to=request.getParameter("to");
		sex=request.getParameter("s");
		age=Integer.parseInt(request.getParameter("a"));
		phno=request.getParameter("phno");
		train_name=request.getParameter("tn");
		date=request.getParameter("d");
		quata=request.getParameter("q");
		berth_choice=request.getParameter("bc");
		class_type=request.getParameter("ct");
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ticket_booking","root","");
		PreparedStatement ps=con.prepareStatement("insert into passenger_details values(?,?,?,?,?,?,?,?,?,?,?)");
		ps.setString(1,name);
		ps.setString(2,from);
		ps.setString(3,to);
		ps.setString(4,sex);
		ps.setInt(5,age);
		ps.setString(6,phno);
		ps.setString(7,train_name);
		ps.setString(8,date);
		ps.setString(9,quata);
		ps.setString(10,berth_choice);
		ps.setString(11,class_type);
		System.out.println(ps);
		ps.executeUpdate();
		ticket=ticket-1;
		p.println("<br>Data Saved.....");
		p.print("<br>to add <a href='ticket-book.html'> click here</a>");
		
		}catch(Exception e) {
			p.print(e);
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter p=response.getWriter();
		p.println("NUMBER OF TICKETS AVAILABLE :"+ticket);	
	}
}


