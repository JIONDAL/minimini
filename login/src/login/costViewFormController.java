package login;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

public class costViewFormController implements Initializable {

	Opener opener = new Opener();
	@FXML
	RadioButton month;
	Stage costViewStage;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	void setCostViewStage(Stage costViewStage) {
		this.costViewStage = costViewStage;
	}

	public void search() {// 이번달 관리비 선택하고 조회 누르면 이번달 관리비창 열리게
		if (month.isSelected()) {
			opener.costViewForm2Open();
			costViewStage.close();
		} else {
			CommonService.msg("현재 페이지가 '월별 관리비 조회' 페이지 입니다.");
		}
	}
}
