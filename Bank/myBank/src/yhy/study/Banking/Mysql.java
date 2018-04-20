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
	 * ���ݿ������
	 * @return
	 */
	public static void getConn(){
		try {
			Class.forName(driver);
			System.out.println("����get");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�Ҳ�������");
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
	 * ���ݿ��query����
	 */
	public static ResultSet querySql(String sql){
		try {
			return statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("���ݶ��󴴽�ʧ��");
			e.printStackTrace();
			return null;
		}

	}
	
	/**
	 * ���ݿ��update����
	 */
	
	public static void updateSql(String sql){
		try {
			statement.executeUpdate(sql);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("���ݿ����ʧ��");
		}
		
	}
	
	/**
	 * �ر����ݿ�
	 */
	public static void sqlClose(){
		try {
			connection.close();
			System.out.println("�ر����ݿ�");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("�ر����ݿ���ֹ���");
			e.printStackTrace();
		}
		try {
			statement.close();
			System.out.println("�ͷ�state");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("�ͷ�state���ֹ���");
			e.printStackTrace();
		}
		
	}
	/**
	 * ���û�������뵽���ݿ���
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
				
				InputStream is=inBlob.getBinaryStream();                //��ȡ������������  
                BufferedInputStream bis=new BufferedInputStream(is);    //����������������  
                  
                byte[] buff=new byte[(int) inBlob.length()];  
                try {
					while(-1!=(bis.read(buff, 0, buff.length))){            //һ����ȫ������buff��  
					    ObjectInputStream in=new ObjectInputStream(new ByteArrayInputStream(buff));  
					    Customer p=(Customer)in.readObject();                   //��������  
					      
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