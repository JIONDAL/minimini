package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

public class costDAO {//관리비 조회를 위함 
	public Connection con;
	private String totalCost;
	private String month;
	public costDAO() {
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
	
	public CostDTO selectMonth(){
		PreparedStatement ps = null;
		ResultSet rs = null;
//		ArrayList<CostDTO> list = null;
		CostDTO costDto = null;
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("MM");
		try {
			ps = con.prepareStatement("SELECT * FROM cost WHERE id=? and month=?");
			ps.setString(1, Login.getId());
			ps.setString(2, formatter.format(calendar.getTime()));//현재 월 가져오기 

			rs = ps.executeQuery();
			
			if(rs.next()) {
				costDto = new CostDTO();
				costDto.setCommonCost(rs.getString(2));
				costDto.setCleanCost(rs.getString(3));
				costDto.setSecCost(rs.getString(4));
				costDto.setElvCost(rs.getString(5));
				costDto.setHeatCost(rs.getString(6));
				costDto.setPowerCost(rs.getString(7));
				costDto.setWaterCost(rs.getString(8));
				costDto.setOperCost(rs.getString(9));
				costDto.setTotalCost(rs.getNString(10));
				costDto.setYear(rs.getNString(11));
				costDto.setMonth(rs.getNString(12));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return costDto;
	}
	
	//월별 관리비 조회
	public Collection<CostDTO> selectMonthly() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<CostDTO> list = new ArrayList<>();
		try {
			ps = con.prepareStatement("SELECT total_cost, month FROM cost WHERE id=?");
			ps.setString(1, Login.getId());
			rs = ps.executeQuery();
			while(rs.next()) {
				CostDTO costDto = new CostDTO(totalCost, month);
				costDto.setTotalCost(rs.getString(1));
				costDto.setMonth(rs.getString(2));
				list.add(costDto);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	
	}
}
