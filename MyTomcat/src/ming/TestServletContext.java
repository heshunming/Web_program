package ming;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServletContext
 */
@WebServlet("/TestServletContext")
public class TestServletContext extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServletContext() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
 
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            
            response.setContentType("text/html;charset=gb2312");
            PrintWriter out = response.getWriter();
            
            // Returns a reference to the ServletContext in which this servlet is running. 
            ServletContext application = this.getServletContext();
            // 从当前application中读取属性accessCount的值
            Integer accessCount = (Integer)application.getAttribute("accessCount");
            if(accessCount == null) {
                accessCount = new Integer(0);
            } else {
                accessCount = new Integer(accessCount.intValue() + 1);
            }
            // 向当前application中插入键（key，属性）值（value）对
            application.setAttribute("accessCount", accessCount);
            
            out.println("<html><head><title>ServletContext测试</title></head><br>"
                    + "<body><td>" + accessCount +"</td>\n"
                    + "</body></html>");
            
        } 
  
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
