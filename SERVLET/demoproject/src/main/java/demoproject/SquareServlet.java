package demoproject;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.Cookie;

@SuppressWarnings("serial")
public class SquareServlet extends HttpServlet {
	@Override 
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

//      InterServlet communication (session saving)	

// 		2.a. session saving by passing k value to other servlet
// 		get k value from req (attribute)
//		Object k =  req.getSession().getAttribute("k");
//		PrintWriter out = res.getWriter();
//		out.println("SquareServlet:  " + k);

//		2.b. passing k as parameter
// 		get k value from req (parameter)
//		int k = Integer.parseInt(req.getParameter("k"));
//		k = k * k;
//		PrintWriter out = res.getWriter();
//		out.println("SquareServlet:  " + k);

//		2.c. Http Sessions
//		HttpSession session = req.getSession();
//		int k = (int) session.getAttribute("k");
//		k *= k;
//		PrintWriter out = res.getWriter();
//		out.println("SquareServlet:  " + k);

//		2.d. Http Cokiees
//		int k = 0;
		// Cookie[] cookies = req.getCookies();
		// for (Cookie c : cookies) {
		// 	if (c.getName().equals("k")) {
		// 		k = (c.getName().equals("k")) ? Integer.parseInt(c.getValue()) : 0;
		// 	}
		// }
//		k *= k;
//		PrintWriter out = res.getWriter();
//		out.println("SquareServlet:  " + k);

		// 3. ServletConfig
//		PrintWriter out = res.getWriter();
//		ServletConfig cg = getServletConfig();
//		String str = cg.getInitParameter("squareServletNameKey");
//		out.println(str);

		// 4. ServletContext
//		PrintWriter out1 = res.getWriter();
//		ServletContext ctx = getServletContext();
//		String str1 = ctx.getInitParameter("name");
//		out1.print(str1);
	}
}