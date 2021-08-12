import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name, password;
		PrintWriter pw=response.getWriter();
		name=request.getParameter("un");
		password=request.getParameter("up");
		pw.println("<br><h2> Following Data Received Successfully .....</h2>");
	if(name.equals("murugan") && password.equals("9942852132"))
		{
					pw.println("<br> LOGIN OK !!!");
		}
		else 
			{
				pw.println("<br> Invalid Login !!!");
			}
	}

}
