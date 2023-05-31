package login;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class costViewFormController implements Initializable {

	Opener opener = new Opener();
	@FXML
	RadioButton month;
	Stage costViewStage;
	costDAO costDao = new costDAO();
	
	//tableview에 데이터 넣기
	@FXML TableView<CostDTO> tableView;
	@FXML TableColumn<CostDTO, String> detailsCol;
	@FXML TableColumn<CostDTO, String> costsCol;
	ObservableList<CostDTO> observableList;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		observableList = FXCollections.observableArrayList();
		
		detailsCol.setCellValueFactory(new PropertyValueFactory<>("month"));
		costsCol.setCellValueFactory(new PropertyValueFactory<>("totalCost"));
		
		Collection<CostDTO> list = costDao.selectMonthly();
		observableList.addAll(list);
		
		tableView.setItems(observableList);
		
		tableView.setFixedCellSize(33);//행 높이
		detailsCol.setStyle("-fx-pref-height: 70px;");//헤더 높이
		detailsCol.setStyle("-fx-alignment: CENTER;");//
		costsCol.setStyle("-fx-pref-height: 70px;");
		costsCol.setStyle("-fx-alignment: CENTER-RIGHT;");
		tableView.setStyle("-fx-font-size:14px;");
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
