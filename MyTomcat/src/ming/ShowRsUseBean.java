package ming;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class ShowRsUseBean
 */
@WebServlet("/ShowRsUseBean")
public class ShowRsUseBean extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        
	        response.setContentType("text/html;charset=gb2312");
	        PrintWriter out = response.getWriter();
	        out.println("<center>");
	        out.println("<table border=1>");	       
	        out.println("<tr><td>id</td>"+"<td>name</td>"+"<td>price</td>"+"<td>inv</td></tr>");
	        
	        // 直接调用DB中的静态方法来为本类服务
	        Connection conn = DB.getConnection();
	        Statement stmt = DB.getStatement(conn);
	        String sql = "select * from my_gods";
	        ResultSet rs = DB.getResultSet(stmt, sql);
	        
	        try {
	            while(rs.next()) {
	                out.println("<tr>");
	                out.println("<td>" + rs.getString("id") + "</td>");
	                out.println("<td>" + rs.getString("name") + "</td>");
	                out.println("<td>" + rs.getString("price") + "</td>");
	                out.println("<td>" + rs.getString("inv") + "</td>");
	                out.println("</tr>");
	            }
	            out.println("</center>");
	        } catch (SQLException e) {
	            System.out.println("执行SQL遍历过程中出现了错误。。。");
	            e.printStackTrace();
	        } finally {
	            // 直接调用DB中的静态方法来关闭一系列被打开的资源
	            DB.close(rs);
	            DB.close(stmt);
	            DB.close(conn);
	        }
	    } 
   

}
