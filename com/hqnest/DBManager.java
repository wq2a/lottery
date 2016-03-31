package lottery.com.hqnest;

import java.sql.*;
import java.io.*;

public class DBManager{

	private static DBManager instance;

	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost/lottery?useUnicode=true&characterEncoding=utf-8&useSSL=false";
	private static final String USER = "root";
	private static final String PASSWORD = "";

	private Connection conn = null;
	private Statement stmt = null;

	private DBManager(){}
	private Connection getConnection(){
		if (conn == null){
			try{
				Class.forName(JDBC_DRIVER);
				conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return conn;
	}

	public static DBManager getInstance(){
		if (instance == null)
			instance = new DBManager();
		return instance;
	}

	public boolean insertLottery(String[] l){
		try{
			stmt = getConnection().createStatement();
			String sql = "SELECT * FROM kj WHERE kj_id='"+l[0]+"'";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				// user already exist
				return false;
			}
			sql = "INSERT INTO kj" +
			  	  "(kj_id,time,blue,red1,red2,red3,red4,red5,red6)" +
			  	  "VALUES('"+l[0] +
			  	  "','" + l[1] +
			  	  "','" + l[2] +
			  	  "','" + l[3] +
			  	  "','" + l[4] +
			  	  "','" + l[5] +
			  	  "','" + l[6] +
			  	  "','" + l[7] +
			  	  "','" + l[8] +
			      "')";
			if(stmt.executeUpdate(sql)==0)
				return false;

		}catch(SQLException se){
      		se.printStackTrace();
   		}catch(Exception e){
      		e.printStackTrace();
   		}finally{
     		return true;
   		}
	}
}