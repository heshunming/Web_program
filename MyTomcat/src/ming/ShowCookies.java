package ming;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowCookies
 */
@WebServlet("/servlet/ShowCookies")
public class ShowCookies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		        
		        response.setContentType("text/html;charset=gb2312");
		        PrintWriter pw = response.getWriter();
		        String title = "Active Cookies";
		        pw.println("init");
		        pw.println("<html><head><title>读取客户端</title></head>"
		                + title
		                + "\n" + "<table border=1 align=center>\n"
		                + "<TH>Cookie Name<TH>Cookie Value" + "<br>");
		        
		        // 读取客户端的所有Cookie
		        Cookie[] cookies = request.getCookies();
		        if(cookies != null) {
		            Cookie cookie;
		            for(int i = 0; i < cookies.length; i++) {
		                cookie = cookies[i];
		                pw.println("<tr>\n" + "<td>" + cookie.getName() +"</td>\n"
		                        + "<td>" + cookie.getValue() +"</td></tr>\n");
		            }
		        }
		        pw.println("</table>\n<body><html>");
		    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
