package ming;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SetCookies extends HttpServlet {

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		        // 向客户端写入Cookie，共6个
		        for(int i = 0; i < 3; i++) {
		            // 3个没有设置时间的Cookie，属于本窗口及其子窗口
		            Cookie cookie = new Cookie("Session-Cookie-" + i, "Cookie-Value-S" + i);
		            response.addCookie(cookie);
		            // 以下3个Cookie设置了时间（3600秒，1小时），属于文本，别的窗口也可以访问到这些Cookie
		            cookie = new Cookie("Persistent-Cookie-" + i, "Cookie-Value-P" + i);
		            cookie.setMaxAge(3600);
		            response.addCookie(cookie);
		        }
		        
		        response.setContentType("text/html;charset=gb2312");
		        PrintWriter out = response.getWriter();
		        String title = "Setting Cookies";
		        out.println("<html><head><title>设置Cookie</title></head>"
		                + "<body>" + title + "<br>"
		                + "There are six cookies associates with this page.<br>"
		                + "to see them,visit the <a href=\"ShowCookies\">\n"
		                + "<code>ShowCookies</code> servlet</a>"
		                + "</body></html>");
		  
		
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request,response);
	}

}
