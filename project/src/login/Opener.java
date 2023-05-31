package login;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
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

	private Stage allMemberStage;
	private Parent allMemberForm;
	public void allMemberFormOpen() {//관리자창 -> 회원관리 -> 회원조회
		FXMLLoader loader = new FXMLLoader(getClass().getResource("allMemberForm.fxml"));
		allMemberStage = new Stage();

		try {
			allMemberForm = loader.load();
			allMemberStage.setScene(new Scene(allMemberForm));
			allMemberStage.setTitle("관리자 화면 - 회원관리 - 회원조회");
			allMemberStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Stage DisMemberStage;
	private Parent DisMemberForm;
	public void DisMemberFormOpen() {//관리자창 -> 회원관리 -> 입주민 승인
		FXMLLoader loader = new FXMLLoader(getClass().getResource("DisMemberForm.fxml"));
		DisMemberStage = new Stage();

		try {
			DisMemberForm = loader.load();
			DisMemberStage.setScene(new Scene(DisMemberForm));
			DisMemberStage.setTitle("관리자 화면 - 회원관리 - 입주민 승인");
			DisMemberStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Stage deleteMemberStage;
	private Parent deleteMemberForm;
	public void deleteMemberFormOpen() {//관리자창 -> 회원관리 -> 탈퇴 회원
		FXMLLoader loader = new FXMLLoader(getClass().getResource("deleteMemberForm.fxml"));
		deleteMemberStage = new Stage();

		try {
			deleteMemberForm = loader.load();
			deleteMemberStage.setScene(new Scene(deleteMemberForm));
			deleteMemberStage.setTitle("관리자 화면 - 회원관리 - 탈퇴 회원");
			deleteMemberStage.show();
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
	
	public void costRegFormOpen() {//관리비관리에 세대별관리비내역등록 열기
		FXMLLoader loader = new FXMLLoader(getClass().getResource("costRegForm.fxml"));
		costManageStage = new Stage();

		try {
			Parent costRegForm = loader.load();
			ComboBox<String> yearCmb = (ComboBox<String>) costRegForm.lookup("#yearCmb");
			yearCmb.setValue("연도 선택");
			yearCmb.getItems().addAll("2023년", "2022년", "2021년", "2020년", "2019년");
			
			ComboBox<String> monthCmb = (ComboBox<String>) costRegForm.lookup("#monthCmb");
			monthCmb.setValue("월 선택");
			monthCmb.getItems().addAll("1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월");
			
			ComboBox<String> complexCmb = (ComboBox<String>) costRegForm.lookup("#complexCmb");
			complexCmb.setValue("동 선택");
			complexCmb.getItems().addAll("101동", "102동", "103동", "104동");
			
			ComboBox<String> unitCmb = (ComboBox<String>) costRegForm.lookup("#unitCmb");
			unitCmb.setValue("호수 선택");
			
			costManageStage.setScene(new Scene(costRegForm));
			costManageStage.setTitle("관리비관리 - 세대별관리비내역등록");
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
			
			ComboBox<String> combo = (ComboBox<String>) communityForm.lookup("#combo");
			combo.getItems().addAll("공지사항", "1:1문의", "자유게시판", "중고거래");
			
			communityStage.setScene(new Scene(communityForm));
			communityStage.setTitle("아파트 커뮤니티");
			communityStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private Stage checkPwStage = new Stage();;
	private Parent checkPwForm;
	
	public void checkPwFormOpen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("checkPwForm.fxml"));
		
		try {
			checkPwForm = loader.load();
			checkPwFormController checkPwFormCon = loader.getController();
			checkPwFormCon.setcheckPwStage(checkPwStage);
			
			checkPwStage.setScene(new Scene(checkPwForm));
			checkPwStage.setTitle("비밀번호 확인");
			checkPwStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void changeInfoFormOpen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("changeInfoForm.fxml"));
		//비밀번호 확인 창(기존창)에서 확인버튼 누르면 회원정보 수정창 열기
		Parent changeInfoForm;
		try {
			changeInfoForm = loader.load();
			changeInfoFormController changeInfoCon = loader.getController();
			changeInfoCon.setChangeInfoForm(changeInfoForm);
			changeInfoCon.setChangeInfoStage(checkPwStage);
			
			checkPwStage.setScene(new Scene(changeInfoForm));
			checkPwStage.setTitle("회원 정보 수정");
			checkPwStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Parent activityForm;
	private Stage activityStage;
	public void activityFormOpen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("activityForm.fxml"));
		activityStage = new Stage();
			
		try {
			activityForm = loader.load();
			
			activityStage.setScene(new Scene(activityForm));
			activityStage.setTitle("활동내역");
			activityStage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Parent costViewForm;
	private Stage costViewStage = new Stage();
	public void costViewFormOpen() {//월별 관리비 조회 창 뜨게 (기본)
		FXMLLoader loader = new FXMLLoader(getClass().getResource("costViewForm.fxml"));
		try {
			costViewForm = loader.load();
			costViewFormController costViewFormCon = loader.getController();
			costViewFormCon.setCostViewStage(costViewStage);
			costViewStage.setScene(new Scene(costViewForm));
			costViewStage.setTitle("월별 관리비 조회");
			costViewStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Parent costViewForm2;
	public void costViewForm2Open() {//이번달 관리비 조회 창 뜨게 (변경)
		FXMLLoader loader = new FXMLLoader(getClass().getResource("costViewForm2.fxml"));
		try {
			costViewForm2 = loader.load();
			costViewForm2Controller costViewForm2Con = loader.getController();
			costViewForm2Con.setCostViewStage(costViewStage);
			costViewStage.setScene(new Scene(costViewForm2));
			costViewStage.setTitle("이번달 관리비 조회");
			costViewStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	@FXML
	private Parent anounceManageForm;
	private Stage anounceManageStage;

	public void anounceManageFormOpen() { // 공지사항 관리 폼 열기
		FXMLLoader loader = new FXMLLoader(getClass().getResource("anounceManageForm.fxml"));
		anounceManageStage = new Stage();
			
		try {
			anounceManageForm = loader.load();
			anounceManageStage.setScene(new Scene(anounceManageForm));
			anounceManageStage.setTitle("공지사항 관리");
			anounceManageStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Parent secretManageForm;
	private Stage secretManageStage;
	public void secretManageFormOpen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("secretManageForm.fxml"));
		secretManageStage = new Stage();
			
		try {
			secretManageForm = loader.load();
			secretManageStage.setScene(new Scene(secretManageForm));
			secretManageStage.setTitle("1:1문의 관리");
			secretManageStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private Parent freeManageForm;
	private Stage freeManageStage;
	public void freeManageFormOpen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("freeManageForm.fxml"));
		freeManageStage = new Stage();
			
		try {
			freeManageForm = loader.load();
			freeManageStage.setScene(new Scene(freeManageForm));
			freeManageStage.setTitle("자유게시판 관리");
			freeManageStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private Parent carrotManageForm;
	private Stage carrotManageStage;
	public void carrotManageFormOpen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("carrotManageForm.fxml"));
		carrotManageStage = new Stage();
			
		try {
			carrotManageForm = loader.load();
			carrotManageStage.setScene(new Scene(carrotManageForm));
			carrotManageStage.setTitle("중고거래 관리");
			carrotManageStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}