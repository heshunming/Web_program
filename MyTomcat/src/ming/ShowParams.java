package ming;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//��ȡ���еĲ��� 
/**
 * Servlet implementation class ShowParams
 */
@WebServlet(
		urlPatterns={"/ShowParams"},
		name="ShowParams")
public class ShowParams extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        response.setContentType("text/html;charset=gb2312");
	        PrintWriter out = response.getWriter();
	        
	        String title = "Reading All Request Parameters";
	        out.println("init");
	        out.println("<html><head><title>��ȡ���в���</title></head>"+"<center>"
	                + title+"</center>"
	                + "\n" + "<table border=1 align=center >\n"
	                + "<TH>Parameter Name<TH>Parameter Value(s)");
	        
	        // Returns an Enumeration of String objects containing the names of the parameters contained in this request. 
	        Enumeration paramNames = request.getParameterNames();
	        // Tests if this enumeration contains more elements. 
	        while(paramNames.hasMoreElements()) {
	            // Returns the next element of this enumeration if this enumeration object has at least one more element to provide. 
	            String paraName = (String)paramNames.nextElement();
	            out.println("<tr><td>" + paraName + "\n<td>");
	            // Returns an array of String objects containing all of the values the given request parameter has, or null if the parameter does not exist. 
	            // ע�����paraName�����������ܼ�˫���ţ���������Ҳ�������paraName�Ķ�Ӧֵ�ˡ�
	            String[] paramValues = request.getParameterValues(paraName);
	            // �������ֻ��һ��ֵ
	            if(paramValues.length == 1) {
	                String paramValue = paramValues[0];
	                if(paramValue.length() == 0) {
	                    out.println("<I>no value</I>");
	                } else {
	                    out.println(paramValue);
	                }
	            }else {
	                // ��������кü���ֵ
	                out.println("<UL>");
	                for(int i = 0; i < paramValues.length; i++) {
	                    out.println("<LI>" + paramValues[i]);
	                }
	                out.println("</UL>");
	            }
	        }
	        out.println("</table>\n<body></html>");
	    } 
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        System.out.println("doPost");
	        doGet(request,response);
	    } 

}