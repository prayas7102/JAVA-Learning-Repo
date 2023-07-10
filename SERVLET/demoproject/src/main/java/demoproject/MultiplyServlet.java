package demoproject;

import java.io.IOException;

import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/mul")
public class MultiplyServlet extends HttpServlet {
	@Override 
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		// 5. Check web-annotation
		Object i =  req.getSession().getAttribute("i");
		PrintWriter out = res.getWriter();
		out.println("SquareServlet:  " + i);
	}
}
