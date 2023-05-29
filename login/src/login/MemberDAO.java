package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class MemberDAO {
	private Connection con;

	public MemberDAO() {
		String url = "jdbc:oracle:thin:@192.168.219.126:1521:xe";
		String user = "oracle";
		String password = "oracle";

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public String login(String id) {
		String sql = "SELECT pw FROM apt WHERE id=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getString("pw");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void insert(
			String id, String pw, String name, 
			String phone, String carNum) {
		String sql = "INSERT INTO apt VALUES(?,?,?,?,?,?)";
		PreparedStatement ps = null;
		String status = "D";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			ps.setString(3, name);
			ps.setString(4, phone);
			ps.setString(5, carNum);
			ps.setString(6, status);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public MemberDTO selectId(String id) {
			
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				ps = con.prepareStatement("SELECT * FROM apt WHERE id=?");
				ps.setString(1, id);
				rs = ps.executeQuery();
				if(rs.next()) {
					MemberDTO member = new MemberDTO();
					member.setId(rs.getString("id"));
					member.setPw(rs.getString("pw"));
					member.setName(rs.getString("name"));
					member.setPhone(rs.getString("phone"));
					member.setCarNum(rs.getString("car_num"));
					member.setStatus(rs.getString("status"));
					return member;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
	
	public Collection<MemberDTO> selectAll(){
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<MemberDTO> members = new ArrayList<>();
		try {
			ps = con.prepareStatement("SELECT * FROM apt WHERE id != 'admin'");
			rs = ps.executeQuery();
			while(rs.next()) {
				MemberDTO member = new MemberDTO();
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setName(rs.getString("name"));
				member.setPhone(rs.getString("phone"));
				member.setCarNum(rs.getString("car_num"));
				member.setStatus(rs.getString("status"));
				members.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return members;
	}
	
	public Collection<MemberDTO> selectDisagree(String status) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<MemberDTO> members = new ArrayList<>();
		try {
			ps = con.prepareStatement("SELECT * FROM apt WHERE id != 'admin'");
			rs = ps.executeQuery();
			while(rs.next()) {
				MemberDTO member = new MemberDTO();
				if(rs.getString("status").equals("D")) {
					member.setId(rs.getString("id"));
					member.setPw(rs.getString("pw"));
					member.setName(rs.getString("name"));
					member.setPhone(rs.getString("phone"));
					member.setCarNum(rs.getString("car_num"));
					member.setStatus(rs.getString("status"));
					members.add(member);
				}else{
					continue;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return members;	
	}
	
	public Collection<MemberDTO> selectAgree(String status) {
		

		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<MemberDTO> members = new ArrayList<>();
		try {
			ps = con.prepareStatement("SELECT * FROM apt WHERE id != 'admin'");
			rs = ps.executeQuery();
			while(rs.next()) {
				MemberDTO member = new MemberDTO();
				if(rs.getString("status").equals("A")) {
					member.setId(rs.getString("id"));
					member.setPw(rs.getString("pw"));
					member.setName(rs.getString("name"));
					member.setPhone(rs.getString("phone"));
					member.setCarNum(rs.getString("car_num"));
					member.setStatus(rs.getString("status"));
					members.add(member);
				}else{
					continue;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return members;	
	}
	
	public void updateAgree(MemberDTO member) {
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("UPDATE apt SET status=? WHERE id=?");
			ps.setString(1, member.getStatus());
			ps.setString(2, member.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(String id) {
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("DELETE FROM apt WHERE id=?");
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
