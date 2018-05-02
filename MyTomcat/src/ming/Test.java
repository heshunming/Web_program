package ming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Test {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
//		Socket s=new Socket("127.0.0.1",8080);
//		PrintWriter pw=new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
//		pw.println("GET / HTTP/1.1");
//		pw.println("Host:localhost");
//		pw.println("Content-Type:text/html");
//		pw.println();
//		pw.flush();
//		
//		BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
//		String str="";
//		while((str=br.readLine())!=null)
//		{
//				System.out.println(str);
//		}
//		br.close();
//		pw.close();
//		s.close();
		
		
		 Socket s = null;
	        PrintWriter pw = null;
	        BufferedReader br = null;
	            
	        try {
	            // 建立连接端口，s指向本地机器tomcat服务器端口上
	            s = new Socket("127.0.0.1",8888);
	            // 对于本程序而言是输出，则相当于是准备向tomcat服务器端口写请求
	            pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
	            // 请求访问页面（此处等同于访问http://localhost:8888/）    
	            pw.println("GET / HTTP/1.1");
	            pw.println("Host: www.bjsxt.com");
	            pw.println("Content-Type:text/html");
	            pw.println("");
	            // 上一句表示请求内容结束
	            pw.flush();
	            // 上面这一段用于本程序向Tomcat服务器发出访问请求（get）
	        }catch(Exception e)
	        {
	        	e.printStackTrace();
	        }finally
	        {
	        	s.close();
	        	pw.close();
	        	
	        }
		
		
	}

}
