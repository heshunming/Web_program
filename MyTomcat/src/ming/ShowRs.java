package ming;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
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
 * Servlet implementation class ShowRs
 */
@WebServlet("/ShowRs")
/**
 * 在Servlet中直接连接数据库，并查询显示信息
 * 每个application都应该有自己的驱动包，放在各自项目的WEB-INF\lib\目录下
 * @author jukey
 *
 */
public class ShowRs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowRs() {
        super();
        // TODO Auto-generated constructor stub
    }

 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        response.setContentType("text/html;charset=gb2312");
        PrintWriter out = response.getWriter();
        out.println("<table border=1>");
        out.println("<tr><td>Content:</td></tr>"); 
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/mygrade?user=root");
            stmt = (Statement) conn.createStatement();
            String sql = "select * from mygra";
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getString("grade") + "</td>");
                out.println("</tr>");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
             if (rs != null) {
                 try {
                     rs.close();
                     rs = null;
                 } catch (SQLException sqlEx) { 
                     sqlEx.printStackTrace();
                 }
             }
             if (stmt != null) {
                 try {
                     stmt.close();
                     stmt = null;
                 } catch (SQLException sqlEx) { 
                     sqlEx.printStackTrace();
                 }
             }
             if (conn != null) {
                 try {
                     conn.close();
                     conn = null;
                 } catch (SQLException sqlEx) { 
                     sqlEx.printStackTrace();
                 }
             }
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
