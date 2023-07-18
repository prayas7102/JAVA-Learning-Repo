package FavouriteFood;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("showvotes")
public class FoodVotes extends HttpServlet {
	private Map<String, Integer> foodVotes;

	@Override
	public void init() {
		// to store votes every food has got
		foodVotes = new HashMap<>();
	}

	// check if user has already voted
	private boolean hasUserVoted(String ipAddress, HttpServletRequest req) {
		Cookie[] cookies = req.getCookies();
		// checking in both cookies and hashmap
		if (cookies != null && cookies.length > 0) {
			for (Cookie c : cookies) {
				if (ipAddress.equals(c.getValue())) {
					System.out.println(c.getName() + " " + c.getValue());
					return true;
				}
			}
		}
		return foodVotes.containsKey(ipAddress);
	}

	// mark if user has already voted
	private void markUserAsVoted(String ipAddress, HttpServletResponse res) {
		// saving in both cookies and hashmap
		Cookie cookie = new Cookie(ipAddress, ipAddress);
		res.addCookie(cookie);
		foodVotes.put(ipAddress, 1);
	}

	// extracting ip address
	private String GetIp(HttpServletRequest req) throws UnknownHostException {
		String ipAddress = req.getRemoteAddr();
		if (ipAddress.equalsIgnoreCase("0:0:0:0:0:0:0:1")) {
			InetAddress inetAddress = InetAddress.getLocalHost();
			String ip = inetAddress.getHostAddress();
			ipAddress = ip;
		}
		return ipAddress;
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		// extracting selected foods
		String[] selectedFoods = req.getParameterValues("favouriteFood");
		// extracting ipAddr
		String ipAddress = GetIp(req);
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		// Check if the user has already voted
		if (!hasUserVoted(ipAddress, req)) {
			// Process the selected foods and update vote counts
			if (selectedFoods != null) {
				for (String food : selectedFoods) {
					int votes = foodVotes.getOrDefault(food, 0);
					foodVotes.put(food, votes + 1);
				}
			}
			// Mark the user as voted
			markUserAsVoted(ipAddress, res);
		} else {
			out.println("This ip address has already voted " + ipAddress);
		}

		// Display the voting results
		out.println("<html><body>");
		out.println("<h2>Voting Results</h2>");
		out.println("<p>");
		foodVotes.entrySet().stream().sorted(Map.Entry.comparingByKey())
				.forEach(entry -> out.println(entry.getKey() + ": " + entry.getValue() + " votes"));
		out.println("</p>");
		out.println("</body></html>");
	}
}
