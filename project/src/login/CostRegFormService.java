package login;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CostRegFormService {
	private MemberDAO memberDao;

	public CostRegFormService() {
		memberDao = new MemberDAO();
	}

	public void selectCost(String id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = memberDao.con.prepareStatement("SELECT * FROM cost where id = ?");
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				CommonService.msg("이미 " + id + "호에 등록된 관리비가 있습니다.");
			}
			
			ps = memberDao.con.prepareStatement("SELECT * FROM apt where id = ?");
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next() == false) {
				CommonService.msg("등록되지 않은 사용자입니다.");
			} else {
				CommonService.msg(id + "호의 관리비를 입력합니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void costReg(CostDTO cost) {
		String dbId = "";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = memberDao.con.prepareStatement("SELECT * FROM apt where id = ?");
			ps.setString(1, cost.getId());
			rs = ps.executeQuery();
			if (rs.next()) {
				dbId = rs.getString("id");
				String sql = "INSERT INTO cost VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				ps = memberDao.con.prepareStatement(sql);
				ps.setString(1, cost.getId());
				ps.setString(2, cost.getCommonCost());
				ps.setString(3, cost.getCleanCost());
				ps.setString(4, cost.getSecCost());
				ps.setString(5, cost.getElvCost());
				ps.setString(6, cost.getHeatCost());
				ps.setString(7, cost.getPowerCost());
				ps.setString(8, cost.getWaterCost());
				ps.setString(9, cost.getOperCost());
				ps.setString(10, cost.getTotalCost());
				ps.setString(11, cost.getYear());
				ps.setString(12, cost.getMonth());
				ps.executeUpdate();
				CommonService.msg("입력하신 " + cost.getId() + "호의 관리비가 등록되었습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
