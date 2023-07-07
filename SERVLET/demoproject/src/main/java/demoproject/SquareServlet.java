package demoproject;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class SquareServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

//      InterServlet communication (session saving)	
		
// 		2.a. session saving by passing k value to other servlet
// 		get k value from req (attribute)
//		int k = (int) req.getAttribute("k");

//		2.c. passing k as parameter
// 		get k value from req (parameter)
		int k = Integer.parseInt(req.getParameter("k"));
		k = k * k;
		
		PrintWriter out = res.getWriter();
		out.println("SquareServlet:  " + k);
	}
}