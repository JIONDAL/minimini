package login;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class anounceManageFormService {
	private MemberDAO memberDao;
	private int num;
	
	public anounceManageFormService() {
		memberDao = new MemberDAO();
	}
	
	public void insert(BoardDTO board) {
		String sql = "SELECT MAX(num) FROM anounce";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = memberDao.con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				num = rs.getInt(1);
				num += 1;
			} else {
				num = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		board.setNum(num);
		
		sql = "INSERT INTO anounce VALUES(?, ?, ?, ?, ?)";
		try {
			ps = memberDao.con.prepareStatement(sql);
			ps.setInt(1, num);
			ps.setString(2, board.getTitle());
			ps.setString(3, board.getContent());
			ps.setString(4, board.getWriter());
			ps.setString(5, board.getWriteTime());
			ps.execute();
			CommonService.msg("공지사항이 등록되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void view() {}

}
