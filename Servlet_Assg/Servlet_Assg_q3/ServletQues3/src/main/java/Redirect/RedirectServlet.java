package Redirect;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/")
public class RedirectServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// original request URL : http://localhost:8080/ServletQues3/
		String originalUrl = request.getRequestURL().toString();

		// Explanation message
		String explanation = "You are being redirected to the bank's website in 5s";

		// URL to redirect to (bank's website)
		String targetUrl = "https://www.pnbindia.in/";

		// Set the content type and write the explanation message
		response.setContentType("text/html");
		response.getWriter().println("<html><head><title>Redirecting...</title></head><body>");
		response.getWriter().println("<h2>" + explanation + "</h2>");
		response.getWriter().println(
				"<p>If you are not redirected automatically, please click <a href=\"" + targetUrl + "\">here</a>.</p>");
		response.getWriter().println("</body></html>");

		// Redirecting to bank website
		response.setHeader("Location", targetUrl);
		response.setHeader("Refresh", "5; URL=" + targetUrl);

	}
}
