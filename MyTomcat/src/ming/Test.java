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
	            // �������Ӷ˿ڣ�sָ�򱾵ػ���tomcat�������˿���
	            s = new Socket("127.0.0.1",8888);
	            // ���ڱ������������������൱����׼����tomcat�������˿�д����
	            pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
	            // �������ҳ�棨�˴���ͬ�ڷ���http://localhost:8888/��    
	            pw.println("GET / HTTP/1.1");
	            pw.println("Host: www.bjsxt.com");
	            pw.println("Content-Type:text/html");
	            pw.println("");
	            // ��һ���ʾ�������ݽ���
	            pw.flush();
	            // ������һ�����ڱ�������Tomcat������������������get��
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
