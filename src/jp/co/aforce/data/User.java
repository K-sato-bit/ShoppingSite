package jp.co.aforce.data;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet(urlPatterns={"/jp.co.aforce.data/user"})
public class User extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource)ic.lookup("java:/comp/env/jdbc/shoppingsite");
			Connection con = ds.getConnection();
			
			PreparedStatement ps = con.prepareStatement("select * from m_user");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				out.print(rs.getInt("id"));
				out.print(":");
				out.print(rs.getString("username"));
				out.print(":");
				out.print(rs.getString("password"));
				out.print(":");
				out.println(rs.getString("name"));
				
			}
			
			ps.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
