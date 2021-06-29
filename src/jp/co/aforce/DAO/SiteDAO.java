package jp.co.aforce.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.Bean.SiteBean;

public class SiteDAO {

//ログイン認証
	public boolean loginCheck(String username, String password) throws ClassNotFoundException, SQLException {

		String sql = "SELECT * FROM m_user WHERE username = ? AND password = ?";

		// データベースへの接続の取得、PreparedStatementの取得
		try (Connection con = ConnectionManager.getConnection(); 
			PreparedStatement pstmt = con.prepareStatement(sql)) {

			// プレースホルダへの値の設定
			pstmt.setString(1, username);
			pstmt.setString(2, password);

			// SQLステートメントの実行
			ResultSet rs = pstmt.executeQuery();

			// 結果の操作
			if (rs.next()) {
				return true;
			}
		}
		return false;
	}


//ユーザ「"m_album情報"をリストで取得」
	public List<SiteBean> selectAll() throws SQLException, ClassNotFoundException {
	
		List<SiteBean> siteList = new ArrayList<SiteBean>();
	
		try (Connection con = ConnectionManager.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM m_album")) {
	
			while (rs.next()) {
				int num = rs.getInt("num");
				String album_name = rs.getString("album_name");
				String day = rs.getString("day");
				int price = rs.getInt("price");
				String image = rs.getString("image");
				

				SiteBean site = new SiteBean();
				site.setNum(num);
				site.setAlbum_name(album_name);
				site.setDay(day);
				site.setPrice(price);
				site.setImage(image);
				
				siteList.add(site);
			}
			return siteList;
		}
	}
	
		
//ユーザ「"価格安い順"をリストで取得」
	public List<SiteBean> cheap() throws SQLException, ClassNotFoundException {
		
		List<SiteBean> cheapList = new ArrayList<SiteBean>();
		
		try (Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM m_album ORDER BY price")) {
		
			while (rs.next()) {
				int num = rs.getInt("num");
				String album_name = rs.getString("album_name");
				String day = rs.getString("day");
				int price = rs.getInt("price");
				String image = rs.getString("image");
					

				SiteBean site = new SiteBean();
				site.setNum(num);
				site.setAlbum_name(album_name);
				site.setDay(day);
				site.setPrice(price);
				site.setImage(image);
					
				cheapList.add(site);
			}
			return cheapList;
			}
		}
	
//ユーザ「"価格高い順"をリストで取得」
	public List<SiteBean> expensive() throws SQLException, ClassNotFoundException {
		
		List<SiteBean> expensiveList = new ArrayList<SiteBean>();
		
		try (Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM m_album ORDER BY price DESC")) {
		
			while (rs.next()) {
				int num = rs.getInt("num");
				String album_name = rs.getString("album_name");
				String day = rs.getString("day");
				int price = rs.getInt("price");
				String image = rs.getString("image");
					

				SiteBean site = new SiteBean();
				site.setNum(num);
				site.setAlbum_name(album_name);
				site.setDay(day);
				site.setPrice(price);
				site.setImage(image);
					
				expensiveList.add(site);
			}
			return expensiveList;
		}
	}	

//ユーザ「"商品名A～Z"をリストで取得」
	public List<SiteBean> az() throws SQLException, ClassNotFoundException {
		
		List<SiteBean> azList = new ArrayList<SiteBean>();
	
		try (Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM m_album ORDER BY album_name")) {
		
			while (rs.next()) {
				int num = rs.getInt("num");
				String album_name = rs.getString("album_name");
				String day = rs.getString("day");
				int price = rs.getInt("price");
				String image = rs.getString("image");
					

				SiteBean site = new SiteBean();
				site.setNum(num);
				site.setAlbum_name(album_name);
				site.setDay(day);
				site.setPrice(price);
				site.setImage(image);
					
				azList.add(site);
			}
			return azList;
		}
	}
	
//ユーザ「"商品名Z～A"をリストで取得」
	public List<SiteBean> za() throws SQLException, ClassNotFoundException {
		
		List<SiteBean> zaList = new ArrayList<SiteBean>();
		
		try (Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM m_album ORDER BY album_name DESC")) {
		
			while (rs.next()) {
				int num = rs.getInt("num");
				String album_name = rs.getString("album_name");
				String day = rs.getString("day");
				int price = rs.getInt("price");
				String image = rs.getString("image");
					

				SiteBean site = new SiteBean();
				site.setNum(num);
				site.setAlbum_name(album_name);
				site.setDay(day);
				site.setPrice(price);
				site.setImage(image);
					
				zaList.add(site);
			}
			return zaList;
		}
	}
	
//購入リストで取得
	public boolean insert (List<SiteBean> cart, SiteBean userinfo) throws SQLException, ClassNotFoundException {

		Connection con = ConnectionManager.getConnection();
		//自動コミットモード設定（無効）
		con.setAutoCommit(false);
			
		for (SiteBean site : cart) {
			PreparedStatement ps = con.prepareStatement("INSERT INTO m_cart VALUES(?,?,?,?,?,?,?)");
				
			
				ps.setString(1, userinfo.getCart_no());
				ps.setInt(2, site.getNum());
				ps.setString(3, site.getAlbum_name());
				ps.setInt(4, site.getPrice());
				ps.setInt(5, site.getAlbum_count());
				ps.setString(6, userinfo.getUsername());
				ps.setInt(7, userinfo.getTotal());
					
				int line = ps.executeUpdate();
				ps.close();
			
				if (line != 1) {
					con.rollback();
					con.setAutoCommit(true);
					con.close();
					
					return false;
				}
			}
			con.commit();
			con.setAutoCommit(true);
			con.close();
		
			return true;
		}
	

//管理者「指定した番号の情報取得」
	public SiteBean select(int num) throws SQLException, ClassNotFoundException {
		
		SiteBean site = new SiteBean();
		
		//指定したno
		String sql = "SELECT * FROM  m_album WHERE num = ?";
		
		//データベース接続
		try(Connection con = ConnectionManager.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);) {
			
			//設定
			ps.setInt(1, num);
			
			ResultSet rs = ps.executeQuery();
			
			//結果
			while (rs.next()){
		
			site.setNum(rs.getInt("num"));
			site.setImage(rs.getString("image"));
			site.setAlbum_name(rs.getString("album_name"));
			site.setDay(rs.getString("day"));
			site.setPrice(rs.getInt("price"));			
			}
		}
		return site;
	}
	
//管理者「登録」
	public int insert(SiteBean site) throws SQLException, ClassNotFoundException {
		int count; //登録数
		String sql = "INSERT INTO m_album VALUES(?,?,?,?,?)";
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, site.getNum());
			ps.setString(2, site.getAlbum_name());
			ps.setString(3, site.getDay());
			ps.setInt(4,  site.getPrice());
			ps.setString(5, site.getImage());
	
			count = ps.executeUpdate();
			
		}
		return count;
	}

//管理者「変更」
	public int update(SiteBean site)throws SQLException, ClassNotFoundException {
	
	int count = 0; //処理件数
	String sql = "UPDATE m_album SET album_name =?, day=?, price=?, image=? WHERE num=?";

	try (Connection con = ConnectionManager.getConnection();
		PreparedStatement ps = con.prepareStatement(sql)) {
		
		
		int num = site.getNum();
		String album_name = site.getAlbum_name();
		String day = site.getDay();
		int price = site.getPrice();
		String image = site.getImage();
		
		ps.setString(1, album_name);
		ps.setString(2, day);
		ps.setInt(3, price);
		ps.setString(4,image);
		ps.setInt(5, num);
		
		count = ps.executeUpdate();
	}
	return count;
	
	}

//管理者「削除」
	public int delete(int num) throws SQLException, ClassNotFoundException {
		int count = 0;
		String sql = "DELETE FROM m_album WHERE num = ?";
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, num);

			count = ps.executeUpdate();
		}

		return count;
	}
}





