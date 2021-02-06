package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Websites
 */
@WebServlet("/Websites")
public class Websites extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Websites() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String value=request.getParameter("website");
		if(value.equals("amazon")) {
			response.sendRedirect("https://www.amazon.com");
		}
		else if(value.equals("flipkart")) {
			response.sendRedirect("https://www.flipkart.com");
		}
		else if(value.equals("myntra")) {
			response.sendRedirect("https://www.myntra.com");
		}
		else if(value.equals("ajio")) {
			response.sendRedirect("https://www.ajio.com");
		}
		else if(value.equals("snapdeal")) {
			response.sendRedirect("https://www.snapdeal.com/");
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
