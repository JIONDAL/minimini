package login;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class LoginService {
	private MemberDAO memberDao;
	
	public LoginService() {
		memberDao = new MemberDAO();
	}
	
	public void login(String id, String pw) {
		if(id == null || id.isEmpty()) {
			return;
		}
		if(pw == null || pw.isEmpty()) {
			return;
		}

		String dbPw = memberDao.login(id);
		if(dbPw != null && dbPw.equals(pw)) {
			// 로그인 성공
			Login.setId(id);
		} else {
			CommonService.msg("아이디 또는 비밀번호가 틀렸습니다.");
		}
	}
}