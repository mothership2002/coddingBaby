package asdf.asdf.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import asdf.asdf.model.vo.ShopMember;

public class dao {
	
	private Connection conn ;//= null ;
	private Statement stmt ;//= null ;
	private ResultSet rs ;//= null ;

	public ShopMember search(String memberId) {
		
		ShopMember shopMember = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "oracle:jdbc:thin@localhost:1521:xe";
			conn = DriverManager.getConnection(url,"id","pass");
			
			String sql = "SELECT * FROM SHOP_MEMBER WHERE MEMBER_ID = " ;//' " + memberId + " ' ";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				shopMember.setMemberId(rs.getString("MEMBER_ID"));
				shopMember.setMemberPw(rs.getString("MEMBER_PASS"));
				shopMember.setPhone(rs.getString("PHONE"));
				shopMember.setGender(rs.getString("GENDER").charAt(0));//.charAt(0));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
//				if(conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return shopMember;
	}
	
}
