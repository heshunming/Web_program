package ming;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DB {
	 // ��ȡ����
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/mydatabase?user=root");
        } catch (ClassNotFoundException e) {
            System.out.println("��������δ�ҵ��������mysql.jdbc��������������");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("ִ�����ݿ����ӹ����г����˴��󡣡���");
            e.printStackTrace();
        }
        return conn;
    }
    
    // ��ȡ���ʽ���
    public static Statement getStatement(Connection conn) {
        Statement stmt = null;
        try {
            if (conn != null) {
                stmt = (Statement) conn.createStatement();
            }
        } catch (SQLException e) {
            System.out.println("ִ�л�ȡ���ʽ�������г����˴��󡣡���");
            e.printStackTrace();
        }        
        return stmt;
    }
    
    // ��ȡ��ѯ�Ľ����
    public static ResultSet getResultSet(Statement stmt, String sql) {
        ResultSet rs = null;
        try {
            if (stmt != null) {
                rs = stmt.executeQuery(sql);
            }
        } catch (SQLException e) {
            System.out.println("ִ�в�ѯ�����г����˴��󡣡���");
            e.printStackTrace();
        }
        return rs;
    }
    
    // �ر�����
    public static void close(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (SQLException e) {
            System.out.println("ִ�йر����ݿ����ӹ����г����˴��󡣡���");
            e.printStackTrace();
        }        
    }
    
    // �رձ��ʽ���
    public static void close(Statement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
                stmt = null;
            }
        } catch (SQLException e) {
            System.out.println("ִ�йرձ��ʽ�������г����˴��󡣡���");
            e.printStackTrace();
        }        
    }
    
    // �رս����
    public static void close(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
                rs = null;
            }
        } catch (SQLException e) {
            System.out.println("ִ�йرս���������г����˴��󡣡���");
            e.printStackTrace();
        }        
    }
}
