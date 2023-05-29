package login;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class myPageFormController implements Initializable {
	private Stage myPageStage;
	private Parent myPageForm;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public void setMyPageStage(Stage myPageStage) {
		this.myPageStage = myPageStage;
	}

	public void setMyPageForm(Parent myPageForm) {
		this.myPageForm = myPageForm;
	}
	
	//마이페이지에서 활동내역/관리비조회/알림내역 등 누르면 실행하는 메서드 작성 
}
