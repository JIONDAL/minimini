package login;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Opener {
	private Stage primaryStage;

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}
	
	private Stage regStage;
	private Parent regForm;
	public void regFormOpen() {//회원가입창 새로열기
		FXMLLoader loader = new FXMLLoader(
				getClass().getResource("regForm.fxml"));
		
		regStage = new Stage();
		try {
			regForm = loader.load();
			RegController regCon = loader.getController();
			regCon.setRegStage(regStage);
			regCon.setRegForm(regForm);
			
			
			regStage.setScene(new Scene(regForm));
			regStage.setTitle("회원가입 화면");
			regStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void adminFormOpen() {//기존 로그인창에 관리자창 열기
		FXMLLoader loader = new FXMLLoader(getClass().getResource("adminForm.fxml"));

		Parent adminForm;
		try {
			adminForm = loader.load();
			primaryStage.setScene(new Scene(adminForm));
			primaryStage.setTitle("관리자 화면");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Stage userManageStage;
	private Parent userManageForm;
	public void userManageFormOpen() {//관리자창에 회원관리 열기
		FXMLLoader loader = new FXMLLoader(getClass().getResource("userManageForm.fxml"));
		userManageStage = new Stage();

		try {
			userManageForm = loader.load();
			userManageStage.setScene(new Scene(userManageForm));
			userManageStage.setTitle("관리자 화면 - 회원관리");
			userManageStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Stage boardManageStage;
	private Parent boardManageForm;
	public void boardManageFormOpen() {//관리자창에 게시판관리 열기
		FXMLLoader loader = new FXMLLoader(getClass().getResource("boardManageForm.fxml"));
		boardManageStage = new Stage();

		try {
			boardManageForm = loader.load();
			boardManageStage.setScene(new Scene(boardManageForm));
			boardManageStage.setTitle("관리자 화면 - 게시판관리");
			boardManageStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Stage costManageStage;
	private Parent costManageForm;
	public void costManageFormOpen() {//관리자창에 관리비관리 열기
		FXMLLoader loader = new FXMLLoader(getClass().getResource("costManageForm.fxml"));
		costManageStage = new Stage();

		try {
			costManageForm = loader.load();
			costManageStage.setScene(new Scene(costManageForm));
			costManageStage.setTitle("관리자 화면 - 관리비관리");
			costManageStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void userFormOpen() {//기존 로그인 창에 유저창 열기
		FXMLLoader loader = new FXMLLoader(getClass().getResource("userForm.fxml"));

		Parent userForm;
		try {
			userForm = loader.load();
			Label id = (Label)userForm.lookup("#id");
			id.setText(Login.getId()+"호");
			
			primaryStage.setScene(new Scene(userForm));
			primaryStage.setTitle("입주민 화면");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Stage myPageStage;
	private Parent myPageForm;
	public void myPageFormOpen() {//마이페이지창 새로 열기
		FXMLLoader loader = new FXMLLoader(getClass().getResource("myPageForm.fxml"));
		myPageStage = new Stage();
		
		try {
			myPageForm = loader.load();
//			myPageFormController myPageFormCon = loader.getController();
//			myPageFormCon.setMyPageStage(myPageStage);
//			myPageFormCon.setMyPageForm(myPageForm);
			
			myPageStage.setScene(new Scene(myPageForm));
			myPageStage.setTitle("마이페이지");
			myPageStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Stage communityStage;
	private Parent communityForm;
	public void communityFormOpen() {//커뮤니티창 새로 열기
		FXMLLoader loader = new FXMLLoader(getClass().getResource("communityForm.fxml"));
		communityStage = new Stage();
		
		try {
			communityForm = loader.load();
			
			communityStage.setScene(new Scene(communityForm));
			communityStage.setTitle("아파트 커뮤니티");
			communityStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}