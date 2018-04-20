package yhy.study.Banking;
import com.mysql.*;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;

import org.omg.CORBA.PRIVATE_MEMBER;


public class Mysql {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/Bank";
	private static String username = "root";
	private static String password = "root";
	private static Connection connection ;
	private static Statement statement;
	/**
	 * 数据库的连接
	 * @return
	 */
	public static void getConn(){
		try {
			Class.forName(driver);
			System.out.println("驱动get");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("找不到驱动");
			e.printStackTrace();
		}
		
		try {
			System.out.println("start connect");
			System.out.println(url);
			connection = DriverManager.getConnection(url, username, password);
			if (connection!=null) {
				System.out.println("connection successful");
				statement = connection.createStatement();
			}
			else {
				System.out.println("error");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("connection fail");
			e.printStackTrace();
		}

	}
	/**
	 * 数据库的query操作
	 */
	public static ResultSet querySql(String sql){
		try {
			return statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("数据对象创建失败");
			e.printStackTrace();
			return null;
		}

	}
	
	/**
	 * 数据库的update操作
	 */
	
	public static void updateSql(String sql){
		try {
			statement.executeUpdate(sql);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("数据库操作失败");
		}
		
	}
	
	/**
	 * 关闭数据库
	 */
	public static void sqlClose(){
		try {
			connection.close();
			System.out.println("关闭数据库");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("关闭数据库出现故障");
			e.printStackTrace();
		}
		try {
			statement.close();
			System.out.println("释放state");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("释放state出现故障");
			e.printStackTrace();
		}
		
	}
	/**
	 * 将用户对象加入到数据库中
	 */
	public static void addCustomer(Customer customer){
		String sql="insert into customers(users) values(?)";  
        PreparedStatement pres;
        try {  
            pres=connection.prepareStatement(sql);  
            pres.setObject(1, customer);       
            pres.executeUpdate();
              
            if(pres!=null)  
                pres.close();  
              
        } catch (SQLException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
		
	}
	
	public static ArrayList<Customer> getCustomers(){
		ArrayList<Customer> arrayList = new ArrayList<Customer>();
		String sql="select * from customers";
		PreparedStatement pres;
		try {
			pres = connection.prepareStatement(sql);
			ResultSet resultSet = pres.executeQuery();
			while (resultSet.next()) {
				Blob inBlob = resultSet.getBlob(1);
				
				InputStream is=inBlob.getBinaryStream();                //获取二进制流对象  
                BufferedInputStream bis=new BufferedInputStream(is);    //带缓冲区的流对象  
                  
                byte[] buff=new byte[(int) inBlob.length()];  
                try {
					while(-1!=(bis.read(buff, 0, buff.length))){            //一次性全部读到buff中  
					    ObjectInputStream in=new ObjectInputStream(new ByteArrayInputStream(buff));  
					    Customer p=(Customer)in.readObject();                   //读出对象  
					      
					    arrayList.add(p);  
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		return arrayList;
	}
	
	
	
}
