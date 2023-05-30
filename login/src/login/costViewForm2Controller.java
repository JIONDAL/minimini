package login;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

public class costViewForm2Controller implements Initializable{
	@FXML RadioButton monthly;
	Opener opener = new Opener();
	Stage costViewStage;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	
	void setCostViewStage(Stage costViewStage) {
		this.costViewStage = costViewStage;
	}
	
	public void search() {
		if(monthly.isSelected()) {
			opener.costViewFormOpen();
			costViewStage.close();
		}else {
			CommonService.msg("현재 페이지가 '이번달 관리비 조회' 페이지 입니다.");
		}
	}
}
